package edu.elte.airlines.dao.interfaces;

import edu.elte.airlines.domain.UserAuth;

public interface UserAuthDao extends CrudDao<UserAuth, Integer>{
	UserAuth findByUserName(final String username);
}
