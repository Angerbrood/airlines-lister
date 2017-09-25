package edu.elte.airlines.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;
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

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}
}
