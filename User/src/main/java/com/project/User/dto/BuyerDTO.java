package com.project.User.dto;

import com.project.User.entity.Buyer;

public class BuyerDTO {
	
	int buyerid;
	String name;
	String password;
	String email;
	String phoneNumber;
	String isPrivileged;
	String rewardPoints;
	String isActive;
	
	public BuyerDTO() {
		super();
	}

	public BuyerDTO(int buyerid, String name, String password, String email, String phoneNumber, String isPrivileged,
			String rewardPoints, String isActive) {
		super();
		this.buyerid = buyerid;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isPrivileged = isPrivileged;
		this.rewardPoints = rewardPoints;
		this.isActive = isActive;
	}

	public int getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
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

	public String getIsPrivileged() {
		return isPrivileged;
	}

	public void setIsPrivileged(String isPrivileged) {
		this.isPrivileged = isPrivileged;
	}

	public String getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(String rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
	public static BuyerDTO valueOf(Buyer buyer) {
		BuyerDTO buyerDTO = new BuyerDTO();
		buyerDTO.setBuyerid(buyer.getBuyerid());
		buyerDTO.setEmail(buyer.getEmail());
		buyerDTO.setIsActive(buyer.getIsActive());
		buyerDTO.setIsPrivileged(buyer.getIsPrivileged());
		buyerDTO.setName(buyer.getName());
		buyerDTO.setPassword(buyer.getPassword());
		buyerDTO.setPhoneNumber(buyer.getPhoneNumber());
		buyerDTO.setRewardPoints(buyer.getRewardPoints());
		return buyerDTO;
	}

	@Override
	public String toString() {
		return "BuyerDTO [buyerid=" + buyerid + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", isPrivileged=" + isPrivileged + ", rewardPoints=" + rewardPoints
				+ ", isActive=" + isActive + "]";
	}
	
	
}
