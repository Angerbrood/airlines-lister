package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.UserDetailDao;
import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.dto.UserDetailDto;
import edu.elte.airlines.service.interfaces.UserPersonalDataService;

public class UserPersonalDataServiceImpl extends AbstractCrudServiceImpl<UserPersonalData, UserDetailDto, Integer>
	implements UserPersonalDataService {

	public UserPersonalDataServiceImpl(UserDetailDao dao) {
		super(UserPersonalData.class, UserDetailDto.class, dao);
	}

}
