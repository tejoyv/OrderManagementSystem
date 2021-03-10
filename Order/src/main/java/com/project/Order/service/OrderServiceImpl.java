package com.project.Order.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Order.dto.OrderdetailsDTO;
import com.project.Order.entity.Orderdetails;
import com.project.Order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderRepository orderRepository;

	public List<OrderdetailsDTO> getAllOrders() throws OrderMSException {
		List<Orderdetails> orderDetails = orderRepository.findAll();
		List<OrderdetailsDTO> orderDTOs = new ArrayList<>();
		
		for(Orderdetails o : orderDetails) {
			OrderdetailsDTO orders = OrderdetailsDTO.valueOf(o);
			orderDTOs.add(orders);
		}
		logger.info("All Order details : {}", orderDTOs);
		return orderDTOs;
		
	}
}
