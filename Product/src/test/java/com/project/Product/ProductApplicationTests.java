package com.project.Product;

import java.util.ArrayList;


import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.Product.Validator.Validator;
import com.project.Product.dto.ProductDTO;
import com.project.Product.entity.Product;
import com.project.Product.repository.ProductRepository;
import com.project.Product.service.ProductMSException;
import com.project.Product.service.ProductService;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ProductApplicationTests{
	
	@Mock
	ProductRepository productRepository;
	
	@Mock
	Validator validator;
	
	@InjectMocks
	ProductService productService=new ProductService();
	
	@Test
	public void getAllProductsValid() throws ProductMSException {
		Product product=new Product(1,"nike","clothing","red","image.jpeg/",400,"shorts","4",4,10,"sports");
		Product product2=new Product(2,"nike","clothing","red","image.jpeg/",400,"shorts2","4",6,10,"sports");
		
		List<Product> products=new ArrayList<>();
		products.add(product2);
		products.add(product);
		
		Mockito.when(productRepository.findAll()).thenReturn(products);
		List<ProductDTO> actual=productService.getAllProducts();
		Assertions.assertEquals(products.isEmpty(), actual.isEmpty());
		
	}
	
	@Test
	public void getProductById() {
		int id=4;
		productService.getProdByProdId(id);
		verify(productRepository, times(1)).findByPRODID(id);
		
	}
	
	@Test
	public void getProductByIdInvalid() {
		int id=4;
		Mockito.when(productRepository.findByPRODID(id)).thenReturn(null);
		productService.getProdByProdId(id);
		verify(productRepository, times(1)).findByPRODID(id);
		
	}
	
	@Test
	public void getProductByCategoryValid() throws ProductMSException {
		Product product=new Product(1,"nike","clothing","red","image.jpeg/",400,"shorts","4",4,10,"sports");
		Product product2=new Product(2,"nike","clothing","red","image.jpeg/",400,"shorts2","4",6,10,"sports");
		
		List<Product> products=new ArrayList<>();
		products.add(product2);
		products.add(product);
		
		Mockito.when(productRepository.findByCATEGORY("Clothing")).thenReturn(products);
		List<ProductDTO> actual=productService.getProductByCategory("Clothing");
		Assertions.assertEquals(products.isEmpty(), actual.isEmpty());
		
	}
	
	@Test
	public void getProductByNameValid() throws ProductMSException {
		Product product=new Product(1,"nike","clothing","red","image.jpeg/",400,"shorts","4",4,10,"sports");
		Product product2=new Product(2,"nike","clothing","red","image.jpeg/",400,"shorts","7",6,10,"sports");
		
		List<Product> products=new ArrayList<>();
		products.add(product2);
		products.add(product);
		
		Mockito.when(productRepository.findByPRODUCTNAME("shorts")).thenReturn(products);
		List<ProductDTO> actual=productService.getProductByName("shorts");
		Assertions.assertEquals(products.isEmpty(), actual.isEmpty());
		
	}
		
}
