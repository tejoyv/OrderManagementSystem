package com.project.Order.entity;

import java.io.Serializable;

public class OrderCompositeId implements Serializable {
	
	private int ORDERID;
	private int PRODID;

	//parameterless constructor
	public OrderCompositeId() {
		super();
	}
	
	
	//parameterised constructor
	public OrderCompositeId(int ORDERID, int PRODID) {
		super();
		this.ORDERID = ORDERID;
		this.PRODID = PRODID;
	}


	//equals and hashcode methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ORDERID;
		result = prime * result + PRODID;
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
		if (ORDERID != other.ORDERID)
			return false;
		if (PRODID != other.PRODID)
			return false;
		return true;
	}
	

}
