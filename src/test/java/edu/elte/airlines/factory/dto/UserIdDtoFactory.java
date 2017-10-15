package edu.elte.airlines.factory.dto;

import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.dto.UserIdDto;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.service.interfaces.CrudService;

public class UserIdDtoFactory extends AbstractDtoFactory<UserId, UserIdDto, Integer> {


    private final UserAuthDtoFactory userAuthDtoFactory;
    private final UserPersonalDataDtoFactory userPersonalDataDtoFactory;

    public UserIdDtoFactory(CrudService<UserId, UserIdDto, Integer> crudService, UserAuthDtoFactory userAuthDtoFactory, UserPersonalDataDtoFactory userPersonalDataDtoFactory) {
        super(crudService);
        this.userAuthDtoFactory = userAuthDtoFactory;
        this.userPersonalDataDtoFactory = userPersonalDataDtoFactory;
    }

    @Override
    public UserIdDto createOne(Object... arguments) {
        UserIdDto result = new UserIdDto();
        result.setUserAuthDto(userAuthDtoFactory.createOne());
        result.setUserPersonalDataDto(userPersonalDataDtoFactory.createOne());
        return result;
    }
}
