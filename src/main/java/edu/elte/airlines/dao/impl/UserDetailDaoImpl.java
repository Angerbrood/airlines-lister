package edu.elte.airlines.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.elte.airlines.dao.interfaces.UserDetailDao;
import edu.elte.airlines.domain.UserDetail;

@Repository
@Transactional
public class UserDetailDaoImpl extends CrudDaoImpl<UserDetail, Integer> implements UserDetailDao {

	public UserDetailDaoImpl(SessionFactory sessionFactory) {
		super(UserDetail.class, sessionFactory);
	}

}
