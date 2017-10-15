package edu.elte.airlines.service.interfaces;

import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.dto.UserIdDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserIdService extends CrudService<UserId, UserIdDto, Integer> {

    UserDetails authenticateUser(String username, String password);
    UserId getUserIdByUserName(String username);

}
