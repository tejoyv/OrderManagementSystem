package com.project.Order.entity;

import java.io.Serializable;

public class OrderCompositeId implements Serializable {
	
	private int orderid;
	private int prodid;

	//parameterless constructor
	public OrderCompositeId() {
		super();
	}
	
	
	//parameterised constructor
	public OrderCompositeId(int orderid, int prodid) {
		super();
		this.orderid = orderid;
		this.prodid = prodid;
	}


	//equals and hashcode methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderid;
		result = prime * result + prodid;
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
		if (orderid != other.orderid)
			return false;
		if (prodid != other.prodid)
			return false;
		return true;
	}
	

}
