package com.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetails")
public class Orderdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderId;
	@Column(nullable = false)
	int buyerId;
	@Column(nullable = false)
	double amount;
	@Column(nullable = false)
	Date date;
	@Column(nullable = false)
	String address;
	@Column(nullable = false)
	String status;

	//parameterised constructor
	public Orderdetails(int orderId, int buyerId, double amount, Date date, String address, String status) {
		super();
		this.orderId = orderId;
		this.buyerId = buyerId;
		this.amount = amount;
		this.date = date;
		this.address = address;
		this.status = status;
	}

	//parameterless constructor
	public Orderdetails() {
		super();
	}

	//getters and setters
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
