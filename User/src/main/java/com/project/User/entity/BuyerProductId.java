package com.project.User.entity;

import java.io.Serializable;

public class BuyerProductId implements Serializable {

	int buyerId;
	int prodId;
	
	public BuyerProductId() {
		super();
	}

	public BuyerProductId(int buyerId, int prodId) {
		super();
		this.buyerId = buyerId;
		this.prodId = prodId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + buyerId;
		result = prime * result + prodId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuyerProductId other = (BuyerProductId) obj;
		if (buyerId != other.buyerId)
			return false;
		if (prodId != other.prodId)
			return false;
		return true;
	}

	

	
	
	

   
}
