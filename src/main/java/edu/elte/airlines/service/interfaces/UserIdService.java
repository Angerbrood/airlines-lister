package edu.elte.airlines.service.interfaces;

import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.dto.UserIdDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserIdService extends CrudService<UserId, UserIdDto, Integer> {

    UserDetails findUserByUsername(String username);
    UserId getUserIdByUserName(String username);

}
