package com.project.Product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	// Fetches products according to product id
	@GetMapping(value = "/api/productid/{prodid}")
	public ProductDTO getProductsById(@PathVariable Integer prodid) throws ProductMSException{
		logger.info("Product details for product with prodid {}", prodid);
		ProductDTO productDTO = productService.getProdByProdId(prodid);
		return productDTO;
	}
	
	// add a product
	@PostMapping(value = "/api/product/add")
	public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO)
	{
		logger.info("Add request for product {}",productDTO);
		ResponseEntity<String>response;
		String successMessage = "Product added successfully !!!!!!!";
		String errorMessage = "Duplicate entry found !!!!!!!";
		try
		{
			productService.addProduct(productDTO);
			response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
		}catch(Exception e) {
			response = new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	// remove product by product id
	@DeleteMapping(value = "/api/product/{prodid}/remove")
	public ResponseEntity<String> removeProduct(@PathVariable Integer prodid)
	{
		logger.info("Remove request for product with productid {}",prodid);
		ResponseEntity<String>response;
		String successMessage = "Product removed successfully !!!!!!!";
		String errorMessage = "No such product found";
		if(productService.removeProduct(prodid)) {
			response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		}else {
			response = new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	// 
}
