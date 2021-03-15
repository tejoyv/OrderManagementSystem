package com.project.Product.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByCATEGORY(String CATEGORY);
	List<Product> findByPRODUCTNAME(String PRODUCTNAME);
	public Product findByPRODID(Integer prodid);
	List<Product> findBySELLERID(Integer SELLERID);
}
