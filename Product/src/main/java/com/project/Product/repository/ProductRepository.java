package com.project.Product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.Product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByCategory(String category);
	List<Product> findByProductname(String productname);
}
