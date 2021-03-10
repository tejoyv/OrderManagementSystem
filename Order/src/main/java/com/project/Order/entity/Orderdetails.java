package com.project.Order.entity;

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
	int orderid;
	@Column(nullable = false)
	int buyerid;
	@Column(nullable = false)
	double amount;
	@Column(nullable = false)
	Date date;
	@Column(nullable = false)
	String address;
	@Column(nullable = false)
	String status;

	//parameterised constructor
	public Orderdetails(int orderid, int buyerId, double amount, Date date, String address, String status) {
		super();
		this.orderid = orderid;
		this.buyerid = buyerid;
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
		return orderid;
	}
	public void setOrderId(int orderid) {
		this.orderid = orderid;
	}
	public int getBuyerId() {
		return buyerid;
	}
	public void setBuyerId(int buyerid) {
		this.buyerid = buyerid;
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
