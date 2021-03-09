package com.project.Order.entity;

import java.io.Serializable;

public class OrderCompositeId implements Serializable {
	
	private int orderId;
	private int prodId;

	//parameterless constructor
	public OrderCompositeId() {
		super();
	}
	
	
	//parameterised constructor
	public OrderCompositeId(int orderId, int prodId) {
		super();
		this.orderId = orderId;
		this.prodId = prodId;
	}


	//equals and hashcode methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
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
		OrderCompositeId other = (OrderCompositeId) obj;
		if (orderId != other.orderId)
			return false;
		if (prodId != other.prodId)
			return false;
		return true;
	}
	
	

}
