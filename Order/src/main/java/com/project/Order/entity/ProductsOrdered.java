package com.project.Order.entity;

import javax.persistence.*;

@Entity
@Table(name= "productsordered")
@IdClass(OrderCompositeId.class)
public class ProductsOrdered {
	
	@Id
	int orderId;
	@Id
	int prodId;
	@Column(nullable = false)
	int sellerId;
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
	public ProductsOrdered(int orderId, int prodId, int sellerId, int quantity, String status, double price) {
		super();
		this.orderId = orderId;
		this.prodId = prodId;
		this.sellerId = sellerId;
		this.quantity = quantity;
		this.status = status;
		this.price = price;
	}

	//getters and setters
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
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
