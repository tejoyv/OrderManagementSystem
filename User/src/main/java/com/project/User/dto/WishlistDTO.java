package com.project.User.dto;

public class WishlistDTO {
	int buyerId;
	int prodId;
	
	//default constructor
	public WishlistDTO() {
		super();
	}
	
	//parameterized constructor
	public WishlistDTO(int buyerId, int prodId) {
		super();
		this.buyerId = buyerId;
		this.prodId = prodId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
}
