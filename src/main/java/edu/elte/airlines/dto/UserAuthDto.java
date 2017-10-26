package edu.elte.airlines.dto;

import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.domain.UserRole;

import java.util.Collection;

public class UserAuthDto implements DtoInterface<Integer> {
	private Integer id;
	private String username;
	private String password;
	private boolean enabled;
	private Collection<UserRole> roles;

	public UserAuthDto() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<UserRole> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
