package com.project.User.dto;
import com.project.User.entity.Seller;

public class SellerDTO {
    int sellerId;
    String name;
    String email;
    String phoneNumber;
    String password;
    String isActive;
    
	public SellerDTO() {
		super();
	}

	public SellerDTO(int sellerId, String name, String email, String phoneNumber, String password, String isActive) {
		super();
		this.sellerId = sellerId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.isActive = isActive;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	public static SellerDTO valueOf(Seller seller) {
		SellerDTO sellerDTO = new SellerDTO();
		sellerDTO.setEmail(seller.getEmail());
		sellerDTO.setIsActive(seller.getIsActive());
		sellerDTO.setName(seller.getName());
		sellerDTO.setPassword(seller.getPassword());
		sellerDTO.setPhoneNumber(seller.getPhoneNumber());
		return sellerDTO;
	}

	@Override
	public String toString() {
		return "SellerDTO [sellerId=" + sellerId + ", name=" + name + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", isActive=" + isActive + "]";
	}
    
	
}
