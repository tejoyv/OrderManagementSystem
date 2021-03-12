package com.project.Order.controller;

import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.project.Order.service.OrderMSException;
import com.project.Order.service.OrderService;
import com.project.Order.dto.CartDTO;
import com.project.Order.dto.OrderdetailsDTO;
import com.project.Order.dto.ProductDTO;
import com.project.Order.entity.Orderdetails;
import com.project.Order.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	@Autowired
	OrderRepository orderRepository;
	
	@Value("${userUrl}")
	public String userUrl;
	@Value("${productUrl}")
	public String productUrl;
	
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
		RestTemplate restTemplate = new RestTemplate();
		int buyerid = orderdetailsDTO.getBUYERID();
		String carturl = userUrl+"getcart/{buyerid}";
		String producturl = productUrl+"productid/{prodid}";
		CartDTO cartDTO = restTemplate.getForObject(carturl, CartDTO.class, buyerid);
		int prodid = cartDTO.getPRODID();
		ProductDTO productDTO = restTemplate.getForObject(producturl, ProductDTO.class, prodid);
		int price = (int) productDTO.getPRICE();
		int quantity = cartDTO.getQUANTITY();
		int amount = price*quantity;
		System.out.println(amount);
		
		//Save to Order details table
		OrderdetailsDTO neworderdetailsDTO = new OrderdetailsDTO();
		neworderdetailsDTO.setBUYERID(orderdetailsDTO.getBUYERID());
		neworderdetailsDTO.setADDRESS(orderdetailsDTO.getADDRESS());
		neworderdetailsDTO.setAMOUNT(amount);
		neworderdetailsDTO.setDate(LocalDate.now());
		neworderdetailsDTO.setSTATUS("ORDER PLACED");
		Orderdetails orderdetails = neworderdetailsDTO.createEntity();
		orderRepository.save(orderdetails);
		
		return productDTO;
	}

}
