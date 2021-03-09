package com.project.User.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(BuyerProductId.class)
@Table(name = "wishlist")
public class Wishlist {
	@Id
	int buyerId;
	@Id
	int prodId;
	
	//default constructor
	public Wishlist() {
		super();
	}
	
	//parameterized constructor
	public Wishlist(int buyerId, int prodId) {
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
