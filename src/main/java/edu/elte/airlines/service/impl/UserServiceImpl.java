package edu.elte.airlines.service.impl;

import java.util.List;

import edu.elte.airlines.dao.interfaces.PassengerDao;
import edu.elte.airlines.model.User;
import edu.elte.airlines.service.interfaces.UserService;
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

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setSsoId(user.getSsoId());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setUserPassengerData(user.getUserPassengerData());
			entity.setUserProfiles(user.getUserProfiles());
		}
	}

	
	public void deleteUserBySSO(String sso) {
		dao.deleteBySSO(sso);
	}

	public List<User> findAllUsers() {
		return super.list();
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		User user = findBySSO(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
