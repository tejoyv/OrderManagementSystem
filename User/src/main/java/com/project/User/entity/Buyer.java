package com.project.User.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int BUYERID;
	@Column(nullable = false)
	String NAME;
	@Column(nullable = false)
	String PASSWORD;
	@Column(nullable = false)
	String EMAIL;
	@Column(nullable = false)
	String PHONENUMBER;
	@Column
	String ISPRIVILEGED;
	@Column
	String REWARDPOINTS;
	@Column
	String ISACTIVE;
	
	//parameterless constructor
	public Buyer() {
		super();
	}
    //parametrized constructor
	public Buyer(int BUYERID, String NAME, String PASSWORD, String EMAIL, String phoneNumber, String ISPRIVILEGED,
			String REWARDPOINTS, String isActive) {
		super();
		this.BUYERID = BUYERID;
		this.NAME = NAME;
		this.PASSWORD = PASSWORD;
		this.EMAIL = EMAIL;
		this.PHONENUMBER = phoneNumber;
		this.ISPRIVILEGED = ISPRIVILEGED;
		this.REWARDPOINTS = REWARDPOINTS;
		this.ISACTIVE = isActive;
	}
    //getters and setters
	public int getBuyerId() {
		return BUYERID;
	}

	public void setBuyerId(int BUYERID) {
		this.BUYERID = BUYERID;
	}

	public String getName() {
		return NAME;
	}

	public void setName(String NAME) {
		this.NAME = NAME;
	}

	public String getPassword() {
		return PASSWORD;
	}

	public void setPassword(String PASSWORD) {
		this.PASSWORD = PASSWORD;
	}

	public String getEmail() {
		return EMAIL;
	}

	public void setEmail(String EMAIL) {
		this.EMAIL = EMAIL;
	}

	public String getPhoneNumber() {
		return PHONENUMBER;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.PHONENUMBER = phoneNumber;
	}

	public String getIsPrivileged() {
		return ISPRIVILEGED;
	}

	public void setIsPrivileged(String ISPRIVILEGED) {
		this.ISPRIVILEGED = ISPRIVILEGED;
	}

	public String getRewardPoints() {
		return REWARDPOINTS;
	}

	public void setRewardPoints(String REWARDPOINTS) {
		this.REWARDPOINTS = REWARDPOINTS;
	}

	public String getIsActive() {
		return ISACTIVE;
	}

	public void setIsActive(String isActive) {
		this.ISACTIVE = isActive;
	}

	
}
