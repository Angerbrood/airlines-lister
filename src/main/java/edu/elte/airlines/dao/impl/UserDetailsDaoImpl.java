package edu.elte.airlines.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.elte.airlines.dao.interfaces.IUserDetailsDao;
import edu.elte.airlines.domain.UserDetails;

@Repository
@Transactional
public class UserDetailsDaoImpl extends CrudDaoImpl<UserDetails, Integer> implements IUserDetailsDao {

	public UserDetailsDaoImpl(SessionFactory sessionFactory) {
		super(UserDetails.class, sessionFactory);
	}

}
