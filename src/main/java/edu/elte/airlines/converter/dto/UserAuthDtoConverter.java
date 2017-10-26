package edu.elte.airlines.converter.dto;

import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.dto.UserAuthDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserAuthDtoConverter implements Converter<UserAuth, UserAuthDto> {

    @Override
    public UserAuthDto convert(UserAuth userAuth) {
        UserAuthDto result = new UserAuthDto();
        result.setId(userAuth.getId());
        result.setUsername(userAuth.getUsername());
        result.setPassword(userAuth.getPassword());
        result.setEnabled(userAuth.isEnabled());
        result.setRoles(userAuth.getRoles());
        return result;
    }
}
