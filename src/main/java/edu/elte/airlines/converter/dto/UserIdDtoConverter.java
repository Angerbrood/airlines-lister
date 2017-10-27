package edu.elte.airlines.converter.dto;


import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.dto.UserAuthDto;
import edu.elte.airlines.dto.UserIdDto;
import edu.elte.airlines.dto.UserPersonalDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserIdDtoConverter implements Converter<UserId, UserIdDto> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserIdDto convert(UserId userId) {
        UserIdDto result = new UserIdDto();
        result.setId(userId.getId());
        result.setUserPersonalDataDto(conversionService.convert(userId.getUserPersonalData(), UserPersonalDataDto.class));
        result.setUserAuthDto(conversionService.convert(userId.getUserAuth(), UserAuthDto.class));
        return result;
    }
}
