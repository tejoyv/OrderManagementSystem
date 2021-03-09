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
	int buyerId;
	@Column(nullable = false)
	String name;
	@Column(nullable = false)
	String password;
	@Column(nullable = false)
	String email;
	@Column(nullable = false)
	String phoneNumber;
	@Column(nullable = false)
	int isPrivileged;
	@Column(nullable = false)
	int rewardPoints;
	@Column(nullable = false)
	int isActive;
	
	//parameterless constructor
	public Buyer() {
		super();
	}

	public Buyer(int buyerid, String name, String password, String email, String phoneNumber, int isPrivileged,
			int rewardPoints, int isActive) {
		super();
		this.buyerId = buyerid;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isPrivileged = isPrivileged;
		this.rewardPoints = rewardPoints;
		this.isActive = isActive;
	}

	public int getBuyerid() {
		return buyerId;
	}

	public void setBuyerid(int buyerid) {
		this.buyerId = buyerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getIsPrivileged() {
		return isPrivileged;
	}

	public void setIsPrivileged(int isPrivileged) {
		this.isPrivileged = isPrivileged;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	
	
	
}
