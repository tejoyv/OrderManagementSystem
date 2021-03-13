package com.project.Order.dto;



import java.sql.Date;

import com.project.Order.entity.*;

public class OrderdetailsDTO {
	int ORDERID;
	int BUYERID;
	double AMOUNT;
	Date DATE;
	String ADDRESS;
	String STATUS;

	//parameterised constructor
	public OrderdetailsDTO(int ORDERID, int BUYERID, double AMOUNT, Date date, String ADDRESS, String STATUS) {
		super();
		this.ORDERID = ORDERID;
		this.BUYERID = BUYERID;
		this.AMOUNT = AMOUNT;
		this.DATE = date;
		this.ADDRESS = ADDRESS;
		this.STATUS = STATUS;
	}
	
	//parameterless constructor
	public OrderdetailsDTO() {
		super();
	}
	
	//getters and setters
		public int getORDERID() {
			return ORDERID;
		}
		public void setORDERID(int ORDERID) {
			this.ORDERID = ORDERID;
		}
		public int getBUYERID() {
			return BUYERID;
		}
		public void setBUYERID(int BUYERID) {
			this.BUYERID = BUYERID;
		}
		public double getAMOUNT() {
			return AMOUNT;
		}
		public void setAMOUNT(double AMOUNT) {
			this.AMOUNT = AMOUNT;
		}
		public Date getDate() {
			return DATE;
		}
		public void setDate(Date date) {
			this.DATE = date;
		}
		public String getADDRESS() {
			return ADDRESS;
		}
		public void setADDRESS(String ADDRESS) {
			this.ADDRESS = ADDRESS;
		}
		public String getSTATUS() {
			return STATUS;
		}
		public void setSTATUS(String STATUS) {
			this.STATUS = STATUS;
		}

		@Override
		public String toString() {
			return "OrderdetailsDTO [ORDERID=" + ORDERID + ", BUYERID=" + BUYERID + ", AMOUNT=" + AMOUNT + ", date="
					+ DATE + ", ADDRESS=" + ADDRESS + ", STATUS=" + STATUS + "]";
		}

	
		// Converts Entity into DTO
		public static OrderdetailsDTO valueOf(Orderdetails orderdetails) {
			OrderdetailsDTO orderdetailsDTO = new OrderdetailsDTO();
			orderdetailsDTO.setORDERID(orderdetails.getORDERID());
			orderdetailsDTO.setBUYERID(orderdetails.getBuyerId());
			orderdetailsDTO.setAMOUNT(orderdetails.getAMOUNT());
			orderdetailsDTO.setDate(orderdetails.getDATE());
			orderdetailsDTO.setADDRESS(orderdetails.getADDRESS());
			orderdetailsDTO.setSTATUS(orderdetails.getSTATUS());
			return orderdetailsDTO;
			
		}
	
}

