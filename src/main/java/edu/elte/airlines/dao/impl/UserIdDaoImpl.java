package edu.elte.airlines.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.elte.airlines.dao.interfaces.IUserIdDao;
import edu.elte.airlines.domain.UserId;

@Repository
@Transactional
public class UserIdDaoImpl extends CrudDaoImpl<UserId, Integer> implements IUserIdDao {

	@Autowired
	public UserIdDaoImpl(SessionFactory sessionFactory) {
		super(UserId.class, sessionFactory);
	}

}
