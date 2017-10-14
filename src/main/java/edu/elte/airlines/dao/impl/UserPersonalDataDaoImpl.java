package edu.elte.airlines.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.elte.airlines.dao.interfaces.UserPersonalDataDao;
import edu.elte.airlines.domain.UserPersonalData;

@Repository
@Transactional
public class UserPersonalDataDaoImpl extends CrudDaoImpl<UserPersonalData, Integer> implements UserPersonalDataDao {

	public UserPersonalDataDaoImpl(SessionFactory sessionFactory) {
		super(UserPersonalData.class, sessionFactory);
	}

}
