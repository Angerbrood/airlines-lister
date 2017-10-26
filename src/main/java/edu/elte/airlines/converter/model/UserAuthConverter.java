package edu.elte.airlines.converter.model;

import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.dto.UserAuthDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserAuthConverter implements Converter<UserAuthDto, UserAuth> {

    @Override
    public UserAuth convert(UserAuthDto userAuthDto) {
        UserAuth result = new UserAuth();
        result.setId(userAuthDto.getId());
        result.setUsername(userAuthDto.getUsername());
        result.setPassword(userAuthDto.getPassword());
        result.setEnabled(userAuthDto.isEnabled());
        result.setRoles(userAuthDto.getRoles());
        return result;
    }
}
