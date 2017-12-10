package edu.elte.airlines.dao.interfaces;

import java.util.List;

import edu.elte.airlines.model.UserProfile;


public interface UserProfileDao extends CrudDao<Integer, UserProfile> {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
