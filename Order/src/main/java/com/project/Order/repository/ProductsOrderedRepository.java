package com.project.Order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Order.entity.OrderCompositeId;
import com.project.Order.entity.ProductsOrdered;

public interface ProductsOrderedRepository extends JpaRepository<ProductsOrdered, OrderCompositeId>{

	public List<ProductsOrdered> findByORDERID(Integer orderid);
}
