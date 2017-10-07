package edu.elte.airlines.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_id")
public class UserId implements ModelInterface<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToOne
	private UserAuth userAuth;
	@OneToOne
	private UserPersonalData userDetails;
	
	public UserId() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserAuth getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(UserAuth userAuth) {
		this.userAuth = userAuth;
	}

	public UserPersonalData getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserPersonalData userDetails) {
		this.userDetails = userDetails;
	}
	
	
}
