package edu.elte.airlines.dao.interfaces;

import java.util.List;

import edu.elte.airlines.model.User;


public interface UserDao extends CrudDao<Integer, User> {

	User findById(int id);
	
	User findBySSO(String sso);
	
	void save(User user);
	
	void deleteBySSO(String sso);
	
	List<User> findAllUsers();

}

