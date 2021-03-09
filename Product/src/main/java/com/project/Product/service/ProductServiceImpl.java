package com.project.Product.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.Product.dto.ProductDTO;
import com.project.Product.entity.Product;
import com.project.Product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductRepository productRepository;
	
	//Get the entire product list
	public List<ProductDTO> getAllProducts() throws ProductMSException{
		System.out.println("In service");
		List<Product>products = productRepository.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();
		
		for(Product p:products) {
			ProductDTO productDTO = ProductDTO.valueOf(p);
			productDTOs.add(productDTO);
		}
		logger.info("Product details : {}", productDTOs);
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getProductByCategory(@PathVariable String category) throws ProductMSException {
		// TODO Auto-generated method stub
		List<Product> product = productRepository.findByCategory(category);
		List<ProductDTO> productDTOs = new ArrayList<>();
		
		for(Product p:product) {
			productDTOs.add(ProductDTO.valueOf(p));
		}
		logger.info("Product details according to category : {}", productDTOs);
		
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getProductByName(String productname) throws ProductMSException {
		// TODO Auto-generated method stub
		
		List<Product> products = productRepository.findByProductname(productname);
		List<ProductDTO> productDTOs = new ArrayList<>();
		
		for(Product p:products) {
			productDTOs.add(ProductDTO.valueOf(p));
		}
		logger.info("Product details according to product name : {}", productDTOs);
		return productDTOs;
	}
	
}
