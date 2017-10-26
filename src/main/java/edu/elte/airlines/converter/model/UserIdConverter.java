package edu.elte.airlines.converter.model;

import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.dto.UserIdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserIdConverter implements Converter<UserIdDto, UserId> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserId convert(UserIdDto userIdDto) {
        UserId result = new UserId();
        result.setId(userIdDto.getId());
        result.setUserPersonalData(conversionService.convert(userIdDto.getUserPersonalDataDto(), UserPersonalData.class));
        result.setUserAuth(conversionService.convert(userIdDto.getUserAuthDto(), UserAuth.class));
        return result;
    }
}
