package com.project.Product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
