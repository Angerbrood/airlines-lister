package edu.elte.airlines.service.interfaces;

import java.util.List;

import edu.elte.airlines.model.User;
import edu.elte.airlines.util.AuthCredentials;


public interface UserService extends CrudService<Integer, User>{
	
	User findById(int id);
	
	User findBySSO(String sso);
	
	Integer saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserBySSO(String sso);

	List<User> findAllUsers(); 
	
	boolean isUserSSOUnique(Integer id, String sso);

	boolean authenticateUser(AuthCredentials credentials);

	boolean isAdmin(User user);

    void registerNewUser(User user);
}