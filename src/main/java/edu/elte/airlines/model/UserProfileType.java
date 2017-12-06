package edu.elte.airlines.model;

import java.io.Serializable;

public enum UserProfileType implements Serializable{
	USER("USER"),
	DBA("DBA"),
	ADMIN("ADMIN");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	public static UserProfileType getType(String type) {
		switch (type) {
			case "USER":
				return USER;
			case "ADMIN":
				return ADMIN;
			default:
				throw new RuntimeException("Invalid user type");
		}
	}
}
