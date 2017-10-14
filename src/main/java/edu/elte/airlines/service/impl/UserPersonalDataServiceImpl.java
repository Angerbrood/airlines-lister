package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.UserPersonalDataDao;
import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.dto.UserPersonalDataDto;
import edu.elte.airlines.service.interfaces.UserPersonalDataService;

public class UserPersonalDataServiceImpl extends AbstractCrudServiceImpl<UserPersonalData, UserPersonalDataDto, Integer>
	implements UserPersonalDataService {

	public UserPersonalDataServiceImpl(UserPersonalDataDao dao) {
		super(UserPersonalData.class, UserPersonalDataDto.class, dao);
	}

}
