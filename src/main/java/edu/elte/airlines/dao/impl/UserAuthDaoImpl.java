package edu.elte.airlines.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public UserAuth findByUserName(final String username) {
        DetachedCriteria criteria = DetachedCriteria.forClass(UserAuth.class);
        criteria.add(Restrictions.eq("username", username));
        Criteria executableCriteria = criteria.getExecutableCriteria(currentSession());
        return (UserAuth) executableCriteria.uniqueResult();
	}

}
