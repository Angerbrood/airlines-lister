package edu.elte.airlines.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.elte.airlines.dao.interfaces.UserIdDao;
import edu.elte.airlines.domain.UserId;

import java.util.List;

@Repository
@Transactional
public class UserIdDaoImpl extends CrudDaoImpl<UserId, Integer> implements UserIdDao {

	@Autowired
	public UserIdDaoImpl(SessionFactory sessionFactory) {
		super(UserId.class, sessionFactory);
	}

	@Override
	public UserId findUserIdByUsername(String username) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserId.class);
		Criteria executableCriteria = criteria.getExecutableCriteria(currentSession());
		List<UserId> userIds = (List<UserId>) executableCriteria.list();
		UserId result = null;
		for(UserId userId : userIds) {
			if(userId.getUserAuth().getUsername().equals(username)) {
				result = userId;
				break;
			}
		}
		result.getUserAuth();
		result.getUserPersonalData();
		return result;
	}
}
