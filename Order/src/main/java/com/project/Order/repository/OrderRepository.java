package com.project.Order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.Order.entity.Orderdetails;
import com.project.Order.entity.ProductsOrdered;

public interface OrderRepository extends JpaRepository<Orderdetails, Integer> {

	public Orderdetails findByORDERID(Integer orderid);
	
}
