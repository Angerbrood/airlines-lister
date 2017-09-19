package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.UserAuthDao;
import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.dto.UserAuthDto;
import edu.elte.airlines.service.interfaces.UserAuthService;

public class UserAuthServiceImpl extends AbstractCrudServiceImpl<UserAuth, UserAuthDto, Integer> 
	implements UserAuthService {

	public UserAuthServiceImpl(UserAuthDao dao) {
		super(UserAuth.class, UserAuthDto.class, dao);
		// TODO Auto-generated constructor stub
	}

}
