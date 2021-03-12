package com.project.Order.dto;


public class CartDTO {

	int BUYERID;
	int PRODID;
	int QUANTITY;
	
	public CartDTO() {
		super();
	}

	public CartDTO(int BUYERID, int PRODID, int QUANTITY) {
		super();
		this.BUYERID = BUYERID;
		this.PRODID = PRODID;
		this.QUANTITY = QUANTITY;
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

	public int getQUANTITY() {
		return QUANTITY;
	}

	public void setQUANTITY(int QUANTITY) {
		this.QUANTITY = QUANTITY;
	}
	
	

	@Override
	public String toString() {
		return "CartDTO [BUYERID=" + BUYERID + ", PRODID=" + PRODID + ", QUANTITY=" + QUANTITY + "]";
	}
	
	
}
