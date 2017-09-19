package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.UserDetailDao;
import edu.elte.airlines.domain.UserDetail;
import edu.elte.airlines.dto.UserDetailDto;
import edu.elte.airlines.service.interfaces.UserDetailService;

public class UserDetailServiceImpl extends AbstractCrudServiceImpl<UserDetail, UserDetailDto, Integer> 
	implements UserDetailService{

	public UserDetailServiceImpl(UserDetailDao dao) {
		super(UserDetail.class, UserDetailDto.class, dao);
		// TODO Auto-generated constructor stub
	}

}
