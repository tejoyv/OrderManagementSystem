package com.project.Order.dto;



public class BuyerDTO {
	
	int BUYERID;
	String NAME;
	String PASSWORD;
	String EMAIL;
	String PHONENUMBER;
	int ISPRIVILEGED;
	int REWARDPOINTS;
	int ISACTIVE;
	
	public BuyerDTO() {
		super();
	}

	public BuyerDTO(int buyerid, String name, String password, String email, String phoneNumber, int isPrivileged,
			int rewardPoints, int isActive) {
		super();
		this.BUYERID = buyerid;
		this.NAME = name;
		this.PASSWORD = password;
		this.EMAIL = email;
		this.PHONENUMBER = phoneNumber;
		this.ISPRIVILEGED = isPrivileged;
		this.REWARDPOINTS = rewardPoints;
		this.ISACTIVE = isActive;
	}

	public int getBuyerid() {
		return BUYERID;
	}

	public void setBuyerid(int buyerid) {
		this.BUYERID = buyerid;
	}

	public String getName() {
		return NAME;
	}

	public void setName(String name) {
		this.NAME = name;
	}

	public String getPassword() {
		return PASSWORD;
	}

	public void setPassword(String password) {
		this.PASSWORD = password;
	}

	public String getEmail() {
		return EMAIL;
	}

	public void setEmail(String email) {
		this.EMAIL = email;
	}

	public String getPhoneNumber() {
		return PHONENUMBER;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.PHONENUMBER = phoneNumber;
	}

	public int getIsPrivileged() {
		return ISPRIVILEGED;
	}

	public void setIsPrivileged(int isPrivileged) {
		this.ISPRIVILEGED = isPrivileged;
	}

	public int getRewardPoints() {
		return REWARDPOINTS;
	}

	public void setRewardPoints(int rewardPoints) {
		this.REWARDPOINTS = rewardPoints;
	}

	public int getIsActive() {
		return ISACTIVE;
	}

	public void setIsActive(int isActive) {
		this.ISACTIVE = isActive;
	}
	

	@Override
	public String toString() {
		return "BuyerDTO [buyerid=" + BUYERID + ", name=" + NAME + ", password=" + PASSWORD + ", email=" + EMAIL
				+ ", phoneNumber=" + PHONENUMBER + ", isPrivileged=" + ISPRIVILEGED + ", rewardPoints=" + REWARDPOINTS
				+ ", isActive=" + ISACTIVE + "]";
	}
	
	
}
