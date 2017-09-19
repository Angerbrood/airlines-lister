package edu.elte.airlines.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.elte.airlines.dao.interfaces.UserAuthDao;
import edu.elte.airlines.domain.UserAuth;

@Repository
@Transactional
public class UserAuthDaoImpl extends CrudDaoImpl<UserAuth, Integer> implements UserAuthDao{

	@Autowired
	public UserAuthDaoImpl(SessionFactory sessionFactory) {
		super(UserAuth.class, sessionFactory);
	}

}
