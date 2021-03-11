package com.project.Order.service;

import java.util.List;

import com.project.Order.dto.OrderdetailsDTO;

public interface OrderService {
	public List<OrderdetailsDTO> getAllOrders() throws OrderMSException;
}
