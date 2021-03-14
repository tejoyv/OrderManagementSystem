package com.project.Product.dto;

import com.project.Product.entity.Subscribedproduct;

public class SubscribedproductDTO {
	int SUBID;
	int BUYERID;
	int PRODID;
	int QUANTITY;
	
	//constructors
	public SubscribedproductDTO() {
		super();
	}
	
	public SubscribedproductDTO(int SUBID, int BUYERID, int PRODID, int QUANTITY) {
		super();
		this.SUBID = SUBID;
		this.BUYERID = BUYERID;
		this.PRODID = PRODID;
		this.QUANTITY = QUANTITY;
	}

	//getters and setters
	public int getSUBID() {
		return SUBID;
	}

	public void setSUBID(int SUBID) {
		this.SUBID = SUBID;
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
	
	// Converts Entity into DTO
		public static SubscribedproductDTO valueOf(Subscribedproduct subscribedproduct) {
			SubscribedproductDTO subscribedproductDTO = new SubscribedproductDTO();
			subscribedproductDTO.setBUYERID(subscribedproduct.getBUYERID());
			subscribedproductDTO.setPRODID(subscribedproduct.getPRODID());
			subscribedproductDTO.setQUANTITY(subscribedproduct.getQUANTITY());
			subscribedproductDTO.setSUBID(subscribedproduct.getSUBID());
			return subscribedproductDTO;
		}

		@Override
		public String toString() {
			return "SubscribedproductDTO [SUBID=" + SUBID + ", BUYERID=" + BUYERID + ", PRODID=" + PRODID
					+ ", QUANTITY=" + QUANTITY + "]";
		}

		public Subscribedproduct createEntity() {
			Subscribedproduct subscribedproduct = new Subscribedproduct();
			subscribedproduct.setBUYERID(this.getBUYERID());
			subscribedproduct.setPRODID(this.getPRODID());
			subscribedproduct.setQUANTITY(this.getQUANTITY());
			return subscribedproduct;
		}
	
		
}

