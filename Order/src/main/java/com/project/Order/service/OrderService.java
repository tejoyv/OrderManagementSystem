package com.project.Order.service;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Order.dto.CartDTO;
import com.project.Order.dto.OrderdetailsDTO;
import com.project.Order.dto.ProductsOrderedDTO;
import com.project.Order.entity.Orderdetails;
import com.project.Order.entity.ProductsOrdered;
import com.project.Order.repository.OrderRepository;
import com.project.Order.repository.ProductsOrderedRepository;

@Service
public class OrderService{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ProductsOrderedRepository productsOrderedRepository;

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

	public List<ProductsOrderedDTO> getProductsOrdered(Integer orderid) {
		List<ProductsOrdered> productsOrdered = productsOrderedRepository.findByORDERID(orderid);
		List<ProductsOrderedDTO> productDTOs = new ArrayList<>();
		
		for(ProductsOrdered products : productsOrdered) {
			ProductsOrderedDTO productsDTO = ProductsOrderedDTO.valueOf(products);
			productDTOs.add(productsDTO);
		}
		return productDTOs;
	}

	public OrderdetailsDTO getOrderDetails(Integer orderid) {
		Orderdetails orderdetails = orderRepository.findByORDERID(orderid);
		
		OrderdetailsDTO orderdetailsDTO = new OrderdetailsDTO();
		if(orderdetails!=null) {
			orderdetailsDTO = OrderdetailsDTO.valueOf(orderdetails);
			List<ProductsOrderedDTO> productsOrderedDTOs = getProductsOrdered(orderid);
			orderdetailsDTO.setORDEREDPRODUCTS(productsOrderedDTOs);
		}
		return orderdetailsDTO;
	}
	
	//reorder
	public String reOrder(int ORDERID,int BUYERID) {
		Orderdetails order = orderRepository.findByORDERID(ORDERID);
		if(order!=null) {
			OrderdetailsDTO orderDetailsDTO = OrderdetailsDTO.valueOf(order);
			if(orderDetailsDTO.getBUYERID()==BUYERID) {
				List<ProductsOrdered> productsOrdered=productsOrderedRepository.findByORDERID(ORDERID);
				List<ProductsOrderedDTO> productList=new ArrayList<>();
				for(ProductsOrdered p:productsOrdered) {
					ProductsOrderedDTO productDTO=ProductsOrderedDTO.valueOf(p);
					productList.add(productDTO);
				}
				
				OrderdetailsDTO newOrderDetailsDTO = new OrderdetailsDTO();
				newOrderDetailsDTO.setBUYERID(orderDetailsDTO.getBUYERID());
				newOrderDetailsDTO.setADDRESS(orderDetailsDTO.getADDRESS());
				newOrderDetailsDTO.setAMOUNT(orderDetailsDTO.getAMOUNT());
				newOrderDetailsDTO.setDATE(LocalDate.now());
				newOrderDetailsDTO.setSTATUS("ORDER PLACED");
				
				Orderdetails orderdetails = newOrderDetailsDTO.createEntity();
		        orderRepository.save(orderdetails);
		        
		        for(ProductsOrderedDTO p: productList) {
		        	ProductsOrderedDTO newProductOrderedDTO = new ProductsOrderedDTO();
			        newProductOrderedDTO.setORDERID(orderdetails.getORDERID());
			        newProductOrderedDTO.setPRODID(p.getPRODID());
			        newProductOrderedDTO.setSELLERID(p.getSELLERID());
			        newProductOrderedDTO.setQUANTITY(p.getQUANTITY());
			        newProductOrderedDTO.setPRICE(p.getPRICE());
			        newProductOrderedDTO.setSTATUS("ORDER PLACED");
			        
			        ProductsOrdered productOrdered = newProductOrderedDTO.createEntity();
			        productsOrderedRepository.save(productOrdered);
		        }
		        return " Reorder Successfull!!!!";
			}
			
			
		}
		
		return "Order not found for the buyer!!";
	}
}
	

