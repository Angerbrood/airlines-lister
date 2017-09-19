package edu.elte.airlines.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user_id")
public class UserId implements ModelInterface<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToOne(mappedBy = "user_id")
	@PrimaryKeyJoinColumn
	private UserAuth userAuth;
	@OneToOne(mappedBy = "user_id")
	@PrimaryKeyJoinColumn
	private UserDetails userDetails;
	
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

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
}
