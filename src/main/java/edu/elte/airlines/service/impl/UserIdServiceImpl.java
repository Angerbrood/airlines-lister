package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dao.interfaces.UserIdDao;
import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.dto.UserIdDto;
import edu.elte.airlines.service.interfaces.UserIdService;

public class UserIdServiceImpl extends AbstractCrudServiceImpl<UserId, UserIdDto, Integer> 
	implements UserIdService{

	public UserIdServiceImpl(UserIdDao dao) {
		super(UserId.class, UserIdDto.class, dao);
	}

}
