package edu.elte.airlines.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_id")
public class UserId implements ModelInterface<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToOne(fetch = FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	private UserAuth userAuth;
	@OneToOne(fetch = FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	private UserPersonalData userPersonalData;
	
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

	public UserPersonalData getUserPersonalData() {
		return userPersonalData;
	}

	public void setUserPersonalData(UserPersonalData userPersonalData) {
		this.userPersonalData = userPersonalData;
	}
	
	
}
