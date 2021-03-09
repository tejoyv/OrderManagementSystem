package com.project.Product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Product.dto.ProductDTO;
import com.project.Product.service.ProductMSException;
import com.project.Product.service.ProductService;

@RestController
public class ProductController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductService productService;
	
	// Fetches all products
	@GetMapping(value = "/api/products",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getAllProducts() throws ProductMSException{
		logger.info("Fetching all products");
		System.out.println("In controller");
		return productService.getAllProducts();
	}
	
	// Fetches products according to category
	@GetMapping(value = "/api/{category}/products",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getProductsByCategory(@PathVariable String category) throws ProductMSException{
		logger.info("Product details for category {}", category);
		return productService.getProductByCategory(category);
	}
	
	// Fetches products according to product name
	@GetMapping(value = "/api/product/{productname}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getProductsByName(@PathVariable String productname) throws ProductMSException{
		logger.info("Product details for product name {}", productname);
		return productService.getProductByName(productname);
	}
}
