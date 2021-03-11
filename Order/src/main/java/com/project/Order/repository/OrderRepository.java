package com.project.Order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.Order.entity.Orderdetails;

public interface OrderRepository extends JpaRepository<Orderdetails, Integer> {
	
}
