package com.project.Product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.Product.Validator.Validator;
import com.project.Product.dto.ProductDTO;
import com.project.Product.dto.SubscribedproductDTO;
import com.project.Product.entity.Product;
import com.project.Product.entity.Subscribedproduct;
import com.project.Product.repository.ProductRepository;
import com.project.Product.repository.SubscribedproductRepository;

@Service
public class ProductService{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SubscribedproductRepository subscribedproductRepository;
	
	@Autowired
	Validator validator;
	
	@Autowired
	Environment environment;
	
	
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

	public List<ProductDTO> getProductByCategory(@PathVariable String category) throws ProductMSException {
		// TODO Auto-generated method stub
		List<Product> product = productRepository.findByCATEGORY(category);
		List<ProductDTO> productDTOs = new ArrayList<>();
		
		for(Product p:product) {
			productDTOs.add(ProductDTO.valueOf(p));
		}
		logger.info("Product details according to category : {}", productDTOs);
		
		return productDTOs;
	}


	public List<ProductDTO> getProductByName(String productname) throws ProductMSException {
		// TODO Auto-generated method stub
		
		List<Product> products = productRepository.findByPRODUCTNAME(productname);
		List<ProductDTO> productDTOs = new ArrayList<>();
		
		for(Product p:products) {
			productDTOs.add(ProductDTO.valueOf(p));
		}
		logger.info("Product details according to product name : {}", productDTOs);
		return productDTOs;
	}

	public ProductDTO getProdByProdId(Integer prodid) {
		Product product = productRepository.findByPRODID(prodid);
		ProductDTO productDTO=null;
		if(product!=null) {
			productDTO = ProductDTO.valueOf(product);
		}
		return productDTO;
	}


	public void addProduct(ProductDTO productDTO) throws Exception {
		validator.validateProduct(productDTO);
		List<Product> product = productRepository.findByPRODUCTNAME(productDTO.getPRODUCTNAME());
		if(product.isEmpty()){
			Product product1 = productDTO.createEntity();
			productRepository.save(product1);
		}
		else {
			throw new Exception(environment.getProperty("PRODUCT_ALREADY_EXISTS"));
		}
	}
	
	public boolean removeProduct(Integer productid)
	{
		Optional<Product> product = productRepository.findById(productid);
		if(product.isPresent()) {
			Product product1 = product.get();
			productRepository.delete(product1);
			return true;
		}else {
			return false;
		}
	}

	public void updateStock(ProductDTO productDTO) throws Exception {
		validator.validateProduct(productDTO);
		Product product = productRepository.findByPRODID(productDTO.getPRODID());
		if(product!=null)
		{
			//Product product1 = productDTO.createEntity();
			product.setSTOCK(productDTO.getSTOCK());
			productRepository.save(product);
		}
	}

	public boolean removeProducts(Integer sellerid)
	{
		List<Product> products=productRepository.findBySELLERID(sellerid);
		if(!products.isEmpty()) {
			for (Product product : products) {
				productRepository.delete(product);
			}
		    return true;
		}
		else
			return false;
	}
}
