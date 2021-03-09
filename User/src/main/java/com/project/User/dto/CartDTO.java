package com.project.User.dto;

import com.project.User.entity.Cart;

public class CartDTO {

	int buyerId;
	int prodId;
	int quantity;
	
	public CartDTO() {
		super();
	}

	public CartDTO(int buyerId, int prodId, int quantity) {
		super();
		this.buyerId = buyerId;
		this.prodId = prodId;
		this.quantity = quantity;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public static CartDTO valueOf(Cart cart) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setBuyerId(cart.getBuyerId());
		cartDTO.setProdId(cart.getProdId());
		cartDTO.setQuantity(cart.getQuantity());
		return cartDTO;
	}

	@Override
	public String toString() {
		return "CartDTO [buyerId=" + buyerId + ", prodId=" + prodId + ", quantity=" + quantity + "]";
	}
	
	
}
