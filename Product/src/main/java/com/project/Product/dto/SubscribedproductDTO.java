package com.project.Product.dto;

import com.project.Product.entity.Subscribedproduct;

public class SubscribedproductDTO {
	int subid;
	int buyerid;
	int prodid;
	int quantity;
	
	//constructors
	public SubscribedproductDTO() {
		super();
	}
	
	public SubscribedproductDTO(int subid, int buyerid, int prodid, int quantity) {
		super();
		this.subid = subid;
		this.buyerid = buyerid;
		this.prodid = prodid;
		this.quantity = quantity;
	}

	//getters and setters
	public int getSubid() {
		return subid;
	}

	public void setSubid(int subid) {
		this.subid = subid;
	}

	public int getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// Converts Entity into DTO
		public static SubscribedproductDTO valueOf(Subscribedproduct subscribedproduct) {
			SubscribedproductDTO subscribedproductDTO = new SubscribedproductDTO();
			subscribedproductDTO.setBuyerid(subscribedproduct.getBuyerid());
			subscribedproductDTO.setProdid(subscribedproduct.getProdid());
			subscribedproductDTO.setQuantity(subscribedproduct.getQuantity());
			subscribedproductDTO.setSubid(subscribedproduct.getSubid());
			return subscribedproductDTO;
		}

		@Override
		public String toString() {
			return "SubscribedproductDTO [subid=" + subid + ", buyerid=" + buyerid + ", prodid=" + prodid
					+ ", quantity=" + quantity + "]";
		}
	
		
}

