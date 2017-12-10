package edu.elte.airlines.service.interfaces;

import java.util.List;

import edu.elte.airlines.model.UserProfile;


public interface UserProfileService extends CrudService<Integer, UserProfile> {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
