package com.project.Order;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;



import com.project.Order.dto.OrderdetailsDTO;
import com.project.Order.entity.Orderdetails;
import com.project.Order.repository.OrderRepository;
import com.project.Order.service.OrderMSException;
import com.project.Order.service.OrderService;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class OrderApplicationTests {
	
	 @Mock
	 OrderRepository orderRepository;
	 
	 @InjectMocks
	 OrderService service= new OrderService();
	
     @Test
     public void getAllOrdersValid() throws OrderMSException{
    	 Orderdetails order=new Orderdetails(1,11,1356,LocalDate.parse("2020-01-28"),"HYD","ORDER PLACED");
    	 Orderdetails order2=new Orderdetails(2,11,1245,LocalDate.parse("2020-01-28"),"INDORE","ORDER PLACED");
    	 
    	 List<Orderdetails> orders = new ArrayList<>();
 		 orders.add(order);
 		 orders.add(order2);
 		 
 		 Mockito.when(orderRepository.findAll()).thenReturn(orders);
		 List<OrderdetailsDTO> actual = service.getAllOrders();
		 Assertions.assertEquals(orders.isEmpty(), actual.isEmpty());
    	 
     }
     
     @Test
     public void getParticularOrderValid() {
    	int id=4;
 		orderRepository.findByORDERID(id);
 		verify(orderRepository, times(1)).findByORDERID(id);
     }
     
}
