package com.project.User.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.User.Validator.Validator;
import com.project.User.dto.BuyerDTO;
import com.project.User.dto.SellerDTO;
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
//		userService.registerBuyer(buyerDTO);
//		ResponseEntity<String> response;
//		if(Validator.validateBuyer(buyerDTO)) {
//			String successMessage = "Buyer added successfully";
//			response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
//		}else {
//			
//		}
//		return response;
	}
	
	// Register a new seller
	@PostMapping(value="/api/seller/register")
	public ResponseEntity<String> registerSeller(@RequestBody SellerDTO sellerDTO) {
		logger.info("Registeration successful for seller {}", sellerDTO);
		userService.registerSeller(sellerDTO);
		String successMessage = "Seller added successfully !!!!!!";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
		return response;
	}
	
	// Login a new buyer
	@PostMapping(value="/api/buyer/login")
	public ResponseEntity<String> loginBuyer(@RequestBody BuyerDTO buyerDTO) throws Exception {
		logger.info("Login successful for buyer {}", buyerDTO);
		String successMessage = "Buyer logged in successfully !!!!!!!";
		String errorMessage = "Invalid email or password !!!!!!!";
		ResponseEntity<String> response;
		if(userService.loginBuyer(buyerDTO)) {
			response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
		}else {
			response = new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	// Login a new seller
	@PostMapping(value="/api/seller/login")
	public ResponseEntity<String> loginSeller(@RequestBody SellerDTO sellerDTO) throws Exception {
		logger.info("Login successful for seller {}", sellerDTO);
		String successMessage = "Seller logged in successfully !!!!!!!";
		String errorMessage = "Invalid email or password !!!!!!!";
		userService.loginSeller(sellerDTO);
		ResponseEntity<String> response;
		if(userService.loginSeller(sellerDTO)){
			response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
		}else {
			response = new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	//fetch all buyers
	@GetMapping(value = "/api/buyers")
	public List<BuyerDTO> getAllBuyers(){
		logger.info("Fetching all buyers");
		return userService.getAllBuyers();
	}
	
	//fetch all sellers
	@GetMapping(value = "/api/sellers")
	public List<SellerDTO> getAllSellers(){
		logger.info("Fetching all sellers");
		return userService.getAllSellers();
	}
	
}
