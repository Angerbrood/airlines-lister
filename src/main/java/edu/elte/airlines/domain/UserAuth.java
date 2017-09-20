package edu.elte.airlines.domain;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_auth")
public class UserAuth implements ModelInterface<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private boolean enabled;
	@OneToMany(fetch = FetchType.LAZY)
	private Collection<UserRole> roles;
	
	
	public UserAuth() {
		
	}
	

	public UserAuth(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public UserAuth(String username, String password, boolean enabled, Collection<UserRole> roles) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Collection<UserRole> getRoles() {
		return Collections.unmodifiableCollection(roles);
	}

	public void setRoles(Collection<UserRole> roles) {
		this.roles = roles;
	}
	
	
	
}
