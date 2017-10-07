package edu.elte.airlines.service.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.dto.UserAuthDto;

public interface UserAuthDetailsService extends CrudService<UserAuth, UserAuthDto, Integer>, UserDetailsService {
	UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException;
}
