package edu.elte.airlines.factory.dto;

import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dto.UserIdDto;
import edu.elte.airlines.factory.AbstractFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserIdDtoFactory extends AbstractFactory<UserIdDto> {
    public UserIdDtoFactory(CrudDao<UserIdDto, ?> dao) {
        super(dao);
    }

    @Autowired
    private UserAuthDtoFactory userAuthDtoFactory;
    @Autowired
    private UserPersonalDataDtoFactory userPersonalDataDtoFactory;

    @Override
    public UserIdDto createOne(Object... arguments) {
        UserIdDto result = new UserIdDto();
        result.setUserAuthDto(userAuthDtoFactory.createOne());
        result.setUserPersonalDataDto(userPersonalDataDtoFactory.createOne());
        return result;
    }
}
