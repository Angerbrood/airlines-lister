package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.UserIdDao;
import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.dto.UserAuthDto;
import edu.elte.airlines.dto.UserIdDto;
import edu.elte.airlines.dto.UserPersonalDataDto;
import edu.elte.airlines.service.interfaces.UserAuthService;
import edu.elte.airlines.service.interfaces.UserIdService;
import edu.elte.airlines.service.interfaces.UserPersonalDataService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Objects;

public class UserIdServiceImpl extends AbstractCrudServiceImpl<UserId, UserIdDto, Integer> 
	implements UserIdService{

	private final UserAuthService userAuthService;
	private final UserPersonalDataService userPersonalDataService;
	private final UserIdDao userIdDao;

	public UserIdServiceImpl(UserIdDao dao, UserAuthService userAuthService, UserPersonalDataService userPersonalDataService) {
		super(UserId.class, UserIdDto.class, dao);
		this.userIdDao = dao;
		this.userAuthService = userAuthService;
		this.userPersonalDataService = userPersonalDataService;
	}

	@Override
	public void createNewUser(UserIdDto userIdDto) {
		Objects.requireNonNull(userIdDto);
		create(userIdDto);
	}

	@Override
	public UserDetails authenticateUser(String username, String password) {
		return userAuthService.authenticateUser(username, password);
	}

	@Override
	public UserId getUserIdByUserName(String username) {
		return userIdDao.findUserIdByUsername(username);
	}
}
