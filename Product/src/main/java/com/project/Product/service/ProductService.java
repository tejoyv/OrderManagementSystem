package com.project.Product.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.project.Product.dto.ProductDTO;

public interface ProductService {
	public List<ProductDTO> getAllProducts() throws ProductMSException;
	public List<ProductDTO> getProductByCategory(String category)throws ProductMSException;
	public List<ProductDTO> getProductByName(String productname) throws ProductMSException;
}
