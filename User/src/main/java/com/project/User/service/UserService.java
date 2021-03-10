package com.project.User.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.User.dto.BuyerDTO;
import com.project.User.entity.Buyer;
import com.project.User.repository.BuyerRepository;

@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BuyerRepository buyerRepository;
	
	public void registerBuyer(BuyerDTO buyerDTO) {
		logger.info("Register request for buyer {}", buyerDTO);
		Buyer buyer = buyerDTO.createEntity();
		buyerRepository.save(buyer);
	}
}
