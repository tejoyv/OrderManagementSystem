package com.project.Order.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.project.Order.service.OrderMSException;
import com.project.Order.service.OrderService;
import com.project.Order.dto.BuyerDTO;
import com.project.Order.dto.CartDTO;
import com.project.Order.dto.OrderdetailsDTO;
import com.project.Order.dto.ProductDTO;
import com.project.Order.dto.ProductsOrderedDTO;
import com.project.Order.entity.Orderdetails;
import com.project.Order.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;


@RestController
@CrossOrigin
public class OrderController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderService orderService;
	@Autowired
	OrderRepository orderRepository;
    @Autowired
    private Gson gson;
	
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
	
	//Place an Order i/p = buyerid, address within validations
	@PostMapping(value="/api/placeOrder")
	public ResponseEntity<String> placeOrder(@RequestBody OrderdetailsDTO orderdetailsDTO){
		int flag=0;
		RestTemplate restTemplate = new RestTemplate();
		int buyerid = orderdetailsDTO.getBUYERID();
		String carturl = userUrl+"getcart/{buyerid}";
		String producturl = productUrl+"productid/{prodid}";
		CartDTO cartDTOs[] = restTemplate.getForObject(carturl, CartDTO[].class, buyerid);
        
		double amount = 0.0;
		for (CartDTO cartDTO2 : cartDTOs) {
			int prodid = cartDTO2.getPRODID();
			ProductDTO productDTO = restTemplate.getForObject(producturl, ProductDTO.class, prodid);
			int price = (int) productDTO.getPRICE();
			int quantity = cartDTO2.getQUANTITY();
			
			amount += (price*quantity);
			if(quantity>=productDTO.getSTOCK()) {
				flag=1;
				break;
			}
			if(orderdetailsDTO.getADDRESS().length()>=100) {
				flag=2;
				break;
			}
			
		}
			
		BuyerDTO buyerDTO = restTemplate.getForObject(userUrl+"buyer/{buyerid}", BuyerDTO.class, buyerid);
		double rewardpoints = buyerDTO.getRewardPoints();
		
		
		if(rewardpoints>0) {
			amount = amount - rewardpoints/4;
			rewardpoints = 0;
		}
		ResponseEntity<String> response=null;
		
		//Save to Order details table
		if(flag==0) {
			OrderdetailsDTO neworderdetailsDTO = new OrderdetailsDTO();
			neworderdetailsDTO.setBUYERID(orderdetailsDTO.getBUYERID());
			neworderdetailsDTO.setADDRESS(orderdetailsDTO.getADDRESS());
			neworderdetailsDTO.setAMOUNT(amount);
			neworderdetailsDTO.setDATE(LocalDate.now());
			neworderdetailsDTO.setSTATUS("ORDER PLACED");
			int updatedRewards = (int) ((amount/100));
			BuyerDTO buyerDTO1 = new BuyerDTO();
			buyerDTO1.setRewardPoints(updatedRewards);
			restTemplate.put(userUrl+"buyer/updaterewards/{buyerid}", buyerDTO1, buyerid);
			Orderdetails orderdetails = neworderdetailsDTO.createEntity();
			orderRepository.save(orderdetails);
			response = new ResponseEntity<String>("Order placed successfully!!!", HttpStatus.OK);
			}
		else if(flag==1) {
			response = new ResponseEntity<String>("Ordered quantity is more than stock available", HttpStatus.BAD_REQUEST);
		}
		else if(flag==2) {
			response = new ResponseEntity<String>("Address should be less than 100 characters", HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
	
	//Fetch all productsOrdered in a particular OrderId
	@GetMapping(value="/api/getProducts/{orderid}")
	public List<ProductsOrderedDTO> getProducts(@PathVariable Integer orderid)
	{
		logger.info("Fetching all products ordered for id {}",orderid);
		return orderService.getProductsOrdered(orderid);
		
	}
	
	//reorder an order
	@PostMapping(value="/api/reOrder/{buyerid}/{orderid}")
	public String reorder(@PathVariable Integer buyerid,@PathVariable Integer orderid)
	{
		return orderService.reOrder(orderid, buyerid);
	}
	
	//Fetch Order details including list of all products ordered in that particular order
	@GetMapping(value="/api/orderdetails/{orderid}")
	public OrderdetailsDTO getOrderDetails(@PathVariable Integer orderid) 
	{
		logger.info("Fetching order details for id {}",orderid);
		return orderService.getOrderDetails(orderid);
		
	}
	
	@KafkaListener(topics = { "newtopic" })
    public void getTopics(@RequestBody String cart) {
        CartDTO cartDTO = gson.fromJson(cart, CartDTO.class);
        System.out.println("BuyerId : "+cartDTO.getBUYERID()+" "+"ProductId : "+cartDTO.getPRODID()+" "+ "Quantity : " +cartDTO.getQUANTITY());
    }
	
	
}
