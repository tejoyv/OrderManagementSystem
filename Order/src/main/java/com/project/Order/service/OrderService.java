package com.project.Order.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Order.dto.CartDTO;
import com.project.Order.dto.OrderdetailsDTO;
import com.project.Order.entity.Orderdetails;
import com.project.Order.repository.OrderRepository;

@Service
public class OrderService{
	
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
	
	public OrderdetailsDTO getParticularOrder(Integer orderid) throws OrderMSException{
		OrderdetailsDTO orderdetailsDTO = null;
		Optional<Orderdetails> orderdetails = orderRepository.findById(orderid);
		if(orderdetails!=null) {
			Orderdetails orderdetails1 = orderdetails.get();
			orderdetailsDTO = OrderdetailsDTO.valueOf(orderdetails1);
		}
		return orderdetailsDTO;
	}
	
}
