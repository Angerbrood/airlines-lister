package edu.elte.airlines.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.elte.airlines.dao.interfaces.UserDetailDao;
import edu.elte.airlines.domain.UserPersonalData;

@Repository
@Transactional
public class UserDetailDaoImpl extends CrudDaoImpl<UserPersonalData, Integer> implements UserDetailDao {

	public UserDetailDaoImpl(SessionFactory sessionFactory) {
		super(UserPersonalData.class, sessionFactory);
	}

}
