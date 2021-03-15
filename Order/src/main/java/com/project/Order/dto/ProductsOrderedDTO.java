package com.project.Order.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import com.project.Order.entity.Orderdetails;
import com.project.Order.entity.ProductsOrdered;

public class ProductsOrderedDTO {
	
	int ORDERID;
	int PRODID;
	int SELLERID;
	int QUANTITY;
	String STATUS;
	double PRICE;
	
	//parameterless constructor
	public ProductsOrderedDTO() {
		super();
	}

	//parameterised constructor
	public ProductsOrderedDTO(int ORDERID, int PRODID, int SELLERID, int QUANTITY, String STATUS, double PRICE) {
		super();
		this.ORDERID = ORDERID;
		this.PRODID = PRODID;
		this.SELLERID = SELLERID;
		this.QUANTITY = QUANTITY;
		this.STATUS = STATUS;
		this.PRICE = PRICE;
	}

	//getters and setters
	public int getORDERID() {
		return ORDERID;
	}
	public void setORDERID(int ORDERID) {
		this.ORDERID = ORDERID;
	}
	public int getPRODID() {
		return PRODID;
	}
	public void setPRODID(int PRODID) {
		this.PRODID = PRODID;
	}
	public int getSELLERID() {
		return SELLERID;
	}
	public void setSELLERID(int SELLERID) {
		this.SELLERID = SELLERID;
	}
	public int getQUANTITY() {
		return QUANTITY;
	}
	public void setQUANTITY(int QUANTITY) {
		this.QUANTITY = QUANTITY;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String STATUS) {
		this.STATUS = STATUS;
	}
	public double getPRICE() {
		return PRICE;
	}
	public void setPRICE(double PRICE) {
		this.PRICE = PRICE;
	}

	@Override
	public String toString() {
		return "ProductsOrderedDTO [ORDERID=" + ORDERID + ", PRODID=" + PRODID + ", SELLERID=" + SELLERID
				+ ", QUANTITY=" + QUANTITY + ", STATUS=" + STATUS + ", PRICE=" + PRICE + "]";
	}
	
	
	public static ProductsOrderedDTO valueOf(ProductsOrdered productsOrdered) {
		ProductsOrderedDTO productsOrderedDTO = new ProductsOrderedDTO();
		productsOrderedDTO.setORDERID(productsOrdered.getORDERID());
		productsOrderedDTO.setPRODID(productsOrdered.getPRODID());
		productsOrderedDTO.setSELLERID(productsOrdered.getSELLERID());
		productsOrderedDTO.setQUANTITY(productsOrdered.getQUANTITY());
		productsOrderedDTO.setPRICE(productsOrdered.getPRICE());
		productsOrderedDTO.setSTATUS(productsOrdered.getSTATUS());
		return productsOrderedDTO;
		
	}

	public ProductsOrdered createEntity() {
		// TODO Auto-generated method stub
		ProductsOrdered productsOrdered = new ProductsOrdered();
		productsOrdered.setORDERID(this.getORDERID());
		productsOrdered.setPRICE(this.getPRICE());
		productsOrdered.setPRODID(this.getPRODID());
		productsOrdered.setQUANTITY(this.getQUANTITY());
		productsOrdered.setSELLERID(this.getSELLERID());
		productsOrdered.setSTATUS(this.getSTATUS());
		return productsOrdered;
	}
}
