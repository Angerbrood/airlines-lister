package edu.elte.airlines.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;
	@ManyToOne(fetch = FetchType.LAZY)
	private UserDetail user;
	@Enumerated(EnumType.STRING)
	private RoleEnum role;
	
	public UserRole() {
		
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public UserDetail getUser() {
		return user;
	}

	public void setUser(UserDetail user) {
		this.user = user;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}
	
	
	
	
}
