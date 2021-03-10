package com.project.Order.entity;

import javax.persistence.*;

@Entity
@Table(name= "productsordered")
@IdClass(OrderCompositeId.class)
public class ProductsOrdered {
	
	@Id
	int orderid;
	@Id
	int prodid;
	@Column(nullable = false)
	int sellerid;
	@Column(nullable = false)
	int quantity;
	@Column(nullable = false)
	String status;
	@Column(nullable = false)
	double price;
	
	//parameterless constructor
	public ProductsOrdered() {
		super();
	}

	//parameterised constructor
	public ProductsOrdered(int orderid, int prodid, int sellerid, int quantity, String status, double price) {
		super();
		this.orderid = orderid;
		this.prodid = prodid;
		this.sellerid = sellerid;
		this.quantity = quantity;
		this.status = status;
		this.price = price;
	}

	//getters and setters
	public int getOrderId() {
		return orderid;
	}
	public void setOrderId(int orderid) {
		this.orderid = orderid;
	}
	public int getProdId() {
		return prodid;
	}
	public void setProdId(int prodid) {
		this.prodid = prodid;
	}
	public int getSellerId() {
		return sellerid;
	}
	public void setSellerId(int sellerid) {
		this.sellerid = sellerid;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
