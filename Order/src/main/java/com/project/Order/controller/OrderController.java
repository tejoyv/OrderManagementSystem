package com.project.Order.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.project.Order.service.OrderMSException;
import com.project.Order.service.OrderService;
import com.project.Order.dto.OrderdetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderService orderService;
	
	//Fetches all Orders
	@GetMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderdetailsDTO> getAllOrders() throws OrderMSException{
		logger.info("Fetching all Orders");
		return orderService.getAllOrders();
	}
	
	// Fetch a particular order
	@GetMapping(value="/api/orders/{orderid}")
	public OrderdetailsDTO getParticularOrder(@PathVariable Integer orderid) throws OrderMSException
	{
		logger.info("Fetching a particular order for id {}",orderid);
		OrderdetailsDTO order = orderService.getParticularOrder(orderid);
		return order;
	}
	
	//
	

}
