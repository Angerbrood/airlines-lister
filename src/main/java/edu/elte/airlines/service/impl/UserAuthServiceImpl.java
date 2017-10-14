package edu.elte.airlines.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import edu.elte.airlines.dao.interfaces.UserAuthDao;
import edu.elte.airlines.domain.RoleEnum;
import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.domain.UserRole;
import edu.elte.airlines.dto.UserAuthDto;
import edu.elte.airlines.service.interfaces.UserAuthService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserAuthServiceImpl extends AbstractCrudServiceImpl<UserAuth, UserAuthDto, Integer>
	implements UserAuthService {

	private UserAuthDao dao;
	
	public UserAuthServiceImpl(UserAuthDao dao) {
		super(UserAuth.class, UserAuthDto.class, dao);
		this.dao = dao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAuth user = dao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
		return buildUserForAuthentication(user, authorities);
	}

	private User buildUserForAuthentication(UserAuth user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(),
			user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Collection<UserRole> collection) {

		Set<GrantedAuthority> setAuths = new HashSet<>();

		for (UserRole userRole : collection) {
			setAuths.add(new SimpleGrantedAuthority(RoleEnum.getStringValue(userRole.getRole())));
		}

		List<GrantedAuthority> Result = new ArrayList<>(setAuths);

		return Result;
	}

}
