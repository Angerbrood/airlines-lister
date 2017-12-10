package edu.elte.airlines.service.impl;

import java.util.List;

import edu.elte.airlines.service.interfaces.UserProfileService;
import org.springframework.transaction.annotation.Transactional;

import edu.elte.airlines.dao.interfaces.UserProfileDao;
import edu.elte.airlines.model.UserProfile;


public class UserProfileServiceImpl extends CrudServiceImpl<Integer, UserProfile> implements UserProfileService {
	

	private final UserProfileDao dao;

	public UserProfileServiceImpl(UserProfileDao dao) {
		super(dao);
		this.dao = dao;
	}

	public UserProfile findById(int id) {
		return dao.findById(id);
	}

	public UserProfile findByType(String type){
		return dao.findByType(type);
	}

	public List<UserProfile> findAll() {
		return dao.findAll();
	}
}
