package edu.elte.airlines.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

public enum RoleEnum {
	ADMIN("ADMIN"), USER("USER"), NONE("NONE");
	
	private final String value;
	
	RoleEnum(String role) {
		value = role;
	}
	
	public static String getStringValue(RoleEnum value) {
		if(value.equals(ADMIN)) {
			return "ADMIN";
		} else if(value.equals(USER)) {
			return "USER";
		} else {
			return "NONE";
		}
	}
}
