package edu.elte.airlines.service.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.dto.UserAuthDto;

public interface UserAuthService extends CrudService<UserAuth, UserAuthDto, Integer>{
	UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException;
}
