package edu.elte.airlines.service.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import edu.elte.airlines.dao.interfaces.PassengerDao;
import edu.elte.airlines.model.User;
import edu.elte.airlines.model.UserProfile;
import edu.elte.airlines.service.interfaces.UserService;
import edu.elte.airlines.util.AuthCredentials;
import org.hibernate.Hibernate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import edu.elte.airlines.dao.interfaces.UserDao;

@Transactional
public class UserServiceImpl extends CrudServiceImpl<Integer, User> implements UserService {


	private final UserDao dao;
    private final PasswordEncoder passwordEncoder;
	private final PassengerDao passengerDao;
	public UserServiceImpl(UserDao dao, PassengerDao passengerDao) {
		super(dao);
		this.dao = dao;
		this.passwordEncoder = new BCryptPasswordEncoder();
		this.passengerDao = passengerDao;
	}

	public User findById(int id) {
		return dao.findById(id);
	}

	public User findBySSO(String sso) {
		User user = dao.findBySSO(sso);
		return user;
	}

	public Integer saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		passengerDao.persist(user.getUserPassengerData());
		return super.create(user);
	}

	public void updateUser(User user) {
		passengerDao.update(user.getUserPassengerData());
		dao.update(user);
	}

	
	public void deleteUserBySSO(String sso) {
		dao.deleteBySSO(sso);
	}

	public List<User> findAllUsers() {
		Set<User> temp = new HashSet<>(super.list());
		List<User> result = new LinkedList<>();
		for(User currentUser : temp) {
			Hibernate.initialize(currentUser.getUserPassengerData());
			Hibernate.initialize(currentUser.getUserProfiles());
			result.add(currentUser);
		}
		return result;
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		User user = findBySSO(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}

	@Override
	public boolean authenticateUser(AuthCredentials credentials) {
		User user = findBySSO(credentials.getUsername());
		if(user!= null) {
			return user.getPassword().equals(credentials.getPassword()) || passwordEncoder.matches(credentials.getPassword(), user.getPassword());
		} else {
			return false;
		}
	}

	@Override
	public boolean isAdmin(User user) {
		Set<UserProfile> profiles = user.getUserProfiles();
		for(UserProfile currentProfile : profiles) {
			if(currentProfile.getType().equals("ADMIN")) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void registerNewUser(User user) {
		if(dao.findBySSO(user.getSsoId()) != null) {
			throw new RuntimeException("Username already taken");
		}
		dao.persist(user);
	}

}
