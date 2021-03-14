package com.project.Product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.project.Product.dto.SubscribedproductDTO;
import com.project.Product.entity.Subscribedproduct;
import com.project.Product.repository.SubscribedproductRepository;

@Service
public class SubscribedProductService {
	
	@Autowired
	SubscribedproductRepository subscribedproductRepository;
	
	@Autowired
	Environment environment;
	
	public void addProduct(SubscribedproductDTO subscribedProductDTO) throws Exception{
		Subscribedproduct sub = subscribedProductDTO.createEntity();
		subscribedproductRepository.save(sub);
	}
	
	
	public List<SubscribedproductDTO> getSubscribedProducts(int buyerId) throws Exception{
		List<Subscribedproduct> subscribedProducts = subscribedproductRepository.findByBUYERID(buyerId);
		List<SubscribedproductDTO> subscribedProductDTOs = new ArrayList<>();
		if(subscribedProducts.isEmpty()) {
			throw new Exception("Service.NO_SUBSCRIBED_PRODUCT_FOUND");
		}else {
			for(Subscribedproduct subscribedProduct : subscribedProducts ) {
				SubscribedproductDTO subscribedProductDTO = SubscribedproductDTO.valueOf(subscribedProduct);
				subscribedProductDTOs.add(subscribedProductDTO);
			}
		return subscribedProductDTOs;
		}
	}
}
