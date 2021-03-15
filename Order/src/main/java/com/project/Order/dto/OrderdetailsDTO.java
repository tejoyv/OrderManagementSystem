package com.project.Order.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.project.Order.entity.*;

public class OrderdetailsDTO {

	int ORDERID;
	int BUYERID;
	double AMOUNT;
	LocalDate DATE;
	String ADDRESS;
	String STATUS;
	List<ProductsOrderedDTO> ORDEREDPRODUCTS;
	
	
	//parameterless constructor
	public OrderdetailsDTO() {
		super();
	}
	
	//parameterised constructor
	public OrderdetailsDTO(int ORDERID, int BUYERID, double AMOUNT, LocalDate DATE, String ADDRESS, String STATUS,
			List<ProductsOrderedDTO> ORDEREDPRODUCTS) {
		super();
		this.ORDERID = ORDERID;
		this.BUYERID = BUYERID;
		this.AMOUNT = AMOUNT;
		this.DATE = DATE;
		this.ADDRESS = ADDRESS;
		this.STATUS = STATUS;
		this.ORDEREDPRODUCTS = ORDEREDPRODUCTS;
	}

	//getters and setters
		
		public List<ProductsOrderedDTO> getORDEREDPRODUCTS() {
			return ORDEREDPRODUCTS;
		}

		public void setORDEREDPRODUCTS(List<ProductsOrderedDTO> ORDEREDPRODUCTS) {
			this.ORDEREDPRODUCTS = ORDEREDPRODUCTS;
		}
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
		public LocalDate getDATE() {
			return DATE;
		}
		public void setDATE(LocalDate DATE) {
			this.DATE = DATE;
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
			return "OrderdetailsDTO [ORDERID=" + ORDERID + ", BUYERID=" + BUYERID + ", AMOUNT=" + AMOUNT + ", DATE="
					+ DATE + ", ADDRESS=" + ADDRESS + ", STATUS=" + STATUS + ", ORDEREDPRODUCTS=" + ORDEREDPRODUCTS
					+ "]";
		}

		// Converts Entity into DTO
		public static OrderdetailsDTO valueOf(Orderdetails orderdetails) {
			OrderdetailsDTO orderdetailsDTO = new OrderdetailsDTO();
			orderdetailsDTO.setORDERID(orderdetails.getORDERID());
			orderdetailsDTO.setBUYERID(orderdetails.getBuyerId());
			orderdetailsDTO.setAMOUNT(orderdetails.getAMOUNT());
			orderdetailsDTO.setDATE(orderdetails.getDATE());
			orderdetailsDTO.setADDRESS(orderdetails.getADDRESS());
			orderdetailsDTO.setSTATUS(orderdetails.getSTATUS());
			return orderdetailsDTO;
		}
		
		//Converts DTO into Entity
		public Orderdetails createEntity() {
			Orderdetails orderdetails = new Orderdetails();
			orderdetails.setORDERID(this.getBUYERID());
			orderdetails.setBuyerId(this.getBUYERID());
			orderdetails.setAMOUNT(this.getAMOUNT());
			orderdetails.setADDRESS(this.getADDRESS());
			orderdetails.setDATE(this.getDATE());
			orderdetails.setSTATUS(this.getSTATUS());
			return orderdetails;
		}		
	
}

