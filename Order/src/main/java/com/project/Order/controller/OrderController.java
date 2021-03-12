package com.project.Order.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.project.Order.service.OrderMSException;
import com.project.Order.service.OrderService;
import com.project.Order.dto.CartDTO;
import com.project.Order.dto.OrderdetailsDTO;
import com.project.Order.dto.ProductDTO;
import com.project.Order.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	
	//Place an Order
	@PostMapping(value="/api/placeOrder")
	public ProductDTO placeOrder(@RequestBody OrderdetailsDTO orderdetailsDTO){
		int buyerid = orderdetailsDTO.getBUYERID();
		System.out.println(buyerid);
		String carturl = "http://localhost:8300/api/getcart/{buyerid}";
		String producturl = "http://localhost:8100/api/productid/{prodid}";
		RestTemplate restTemplate = new RestTemplate();
		CartDTO cartDTO = restTemplate.getForObject(carturl, CartDTO.class, buyerid);
		int prodid = cartDTO.getPRODID();
		System.out.println("Before RT:"+prodid);
		ProductDTO productDTO = restTemplate.getForObject(producturl, ProductDTO.class, prodid);
		System.out.println(productDTO.getPRICE());
		int price = (int) productDTO.getPRICE();
		int quantity = cartDTO.getQUANTITY();
		int amount = price*quantity;
		System.out.println(amount);
		return productDTO;
	}

}
