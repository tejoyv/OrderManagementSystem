package com.project.Order.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import com.project.Order.entity.Orderdetails;
import com.project.Order.entity.ProductsOrdered;

public class ProductsOrderedDTO {
	
	int orderId;
	int prodId;
	int sellerId;
	int quantity;
	String status;
	double price;
	
	//parameterless constructor
	public ProductsOrderedDTO() {
		super();
	}

	//parameterised constructor
	public ProductsOrderedDTO(int orderId, int prodId, int sellerId, int quantity, String status, double price) {
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

	@Override
	public String toString() {
		return "ProductsOrderedDTO [orderId=" + orderId + ", prodId=" + prodId + ", sellerId=" + sellerId
				+ ", quantity=" + quantity + ", status=" + status + ", price=" + price + "]";
	}
	
	
	public static ProductsOrderedDTO valueOf(ProductsOrdered productsOrdered) {
		ProductsOrderedDTO productsOrderedDTO = new ProductsOrderedDTO();
		productsOrderedDTO.setOrderId(productsOrdered.getOrderId());
		productsOrderedDTO.setProdId(productsOrdered.getProdId());
		productsOrderedDTO.setSellerId(productsOrdered.getSellerId());
		productsOrderedDTO.setQuantity(productsOrdered.getQuantity());
		productsOrderedDTO.setPrice(productsOrdered.getPrice());
		productsOrderedDTO.setStatus(productsOrdered.getStatus());
		return productsOrderedDTO;
		
	}
}
