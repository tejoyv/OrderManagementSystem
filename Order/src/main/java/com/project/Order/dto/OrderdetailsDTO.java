package com.project.Order.dto;



import java.sql.Date;

import com.project.Order.entity.*;

public class OrderdetailsDTO {
	int orderId;
	int buyerId;
	double amount;
	Date date;
	String address;
	String status;

	//parameterised constructor
	public OrderdetailsDTO(int orderId, int buyerId, double amount, Date date, String address, String status) {
		super();
		this.orderId = orderId;
		this.buyerId = buyerId;
		this.amount = amount;
		this.date = date;
		this.address = address;
		this.status = status;
	}
	
	//parameterless constructor
	public OrderdetailsDTO() {
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

		@Override
		public String toString() {
			return "OrderdetailsDTO [orderId=" + orderId + ", buyerId=" + buyerId + ", amount=" + amount + ", date="
					+ date + ", address=" + address + ", status=" + status + "]";
		}

	
		// Converts Entity into DTO
		public static OrderdetailsDTO valueOf(Orderdetails orderdetails) {
			OrderdetailsDTO orderdetailsDTO = new OrderdetailsDTO();
			orderdetailsDTO.setOrderId(orderdetails.getOrderId());
			orderdetailsDTO.setBuyerId(orderdetails.getBuyerId());
			orderdetailsDTO.setAmount(orderdetails.getAmount());
			orderdetailsDTO.setDate(orderdetails.getDate());
			orderdetailsDTO.setAddress(orderdetails.getAddress());
			orderdetailsDTO.setStatus(orderdetails.getStatus());
			return orderdetailsDTO;
			
		}
	
}

