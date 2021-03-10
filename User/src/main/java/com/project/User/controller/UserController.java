package com.project.User.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.User.dto.BuyerDTO;
import com.project.User.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// Register a new buyer
	@PostMapping(value="/api/buyer/register")
	public void registerBuyer(@RequestBody BuyerDTO buyerDTO) {
		logger.info("Registeration successful for buyer {}", buyerDTO);
		userService.registerBuyer(buyerDTO);
	}
	
	// Register a new buyer
	@PostMapping(value="/api/buyer/register")
	public void registerSeller(@RequestBody BuyerDTO buyerDTO) {
		logger.info("Registeration successful for buyer {}", buyerDTO);
		userService.registerBuyer(buyerDTO);
	}
	
	
	
}
