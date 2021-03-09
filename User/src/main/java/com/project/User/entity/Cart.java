package com.project.User.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(BuyerProductId.class)
public class Cart {
     
	@Id
	int buyerId;
	@Id
	int prodId;
	@Column(nullable = false)
	int quantity;
	
	public Cart() {
		super();
	}

	public Cart(int buyerId, int prodId, int quantity) {
		super();
		this.buyerId = buyerId;
		this.prodId = prodId;
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
