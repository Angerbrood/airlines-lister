package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.UserIdDao;
import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.dto.UserIdDto;
import edu.elte.airlines.service.interfaces.UserIdService;
import edu.elte.airlines.service.interfaces.UserPersonalDataService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class UserIdServiceImpl extends AbstractCrudServiceImpl<UserId, UserIdDto, Integer> 
	implements UserIdService{

	private final UserDetailsService userAuthDetailsService;
	private final UserPersonalDataService userPersonalDataService;
	private final UserIdDao userIdDao;

	public UserIdServiceImpl(UserIdDao dao, UserDetailsService userAuthDetailsService, UserPersonalDataService userPersonalDataService) {
		super(UserId.class, UserIdDto.class, dao);
		this.userIdDao = dao;
		this.userAuthDetailsService = userAuthDetailsService;
		this.userPersonalDataService = userPersonalDataService;
	}

	@Override
	public UserDetails findUserByUsername(String username) {
		return userAuthDetailsService.loadUserByUsername(username);
	}

	@Override
	public UserId getUserIdByUserName(String username) {
		return userIdDao.findUserIdByUsername(username);
	}
}
