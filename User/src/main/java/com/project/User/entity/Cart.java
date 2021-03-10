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
	int BUYERID;
	@Id
	int PRODID;
	@Column(nullable = false)
	int quantity;
	
	public Cart() {
		super();
	}

	public Cart(int BUYERID, int PRODID, int quantity) {
		super();
		this.BUYERID = BUYERID;
		this.PRODID = PRODID;
		this.quantity = quantity;
	}

	public int getBUYERID() {
		return BUYERID;
	}

	public void setBUYERID(int BUYERID) {
		this.BUYERID = BUYERID;
	}

	public int getPRODID() {
		return PRODID;
	}

	public void setPRODID(int PRODID) {
		this.PRODID = PRODID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
