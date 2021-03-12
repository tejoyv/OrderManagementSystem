package com.project.User.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.User.Validator.Validator;
import com.project.User.dto.BuyerDTO;
import com.project.User.dto.CartDTO;
import com.project.User.dto.SellerDTO;
import com.project.User.dto.WishlistDTO;
import com.project.User.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	Environment environment;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// Register a new buyer
	@PostMapping(value="/api/buyer/register")
	public ResponseEntity<String> registerBuyer(@RequestBody BuyerDTO buyerDTO) {
		ResponseEntity<String> response;
		try {
			userService.registerBuyer(buyerDTO);
			logger.info("Registeration successful for buyer {}", buyerDTO);
			String successMessage = "Buyer added successfully";
			response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	// Register a new seller
	@PostMapping(value="/api/seller/register")
	public ResponseEntity<String> registerSeller(@RequestBody SellerDTO sellerDTO) {
		ResponseEntity<String> response;
		try {
			userService.registerSeller(sellerDTO);
			logger.info("Registeration successful for seller {}", sellerDTO);
			String successMessage = "Seller added successfully";
			response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
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
	
	@DeleteMapping(value="/api/buyer/deactivate/{buyerid}")
	public ResponseEntity<String> deleteBuyer(@PathVariable Integer buyerid){
		logger.info("Buyer successfully deleted with buyerid {}", buyerid);
		String successMessage = "Buyer deactivated successfully !!!!!!!";
		String errorMessage = "Something went wrong !!!!!!!";
		ResponseEntity<String> response;
		userService.deleteBuyer(buyerid);
			response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping(value="/api/seller/deactivate/{sellerid}")
	public ResponseEntity<String> deleteSeller(@PathVariable Integer sellerid){
		logger.info("Seller successfully deleted with sellerid {}", sellerid);
		String successMessage = "Seller deactivated successfully !!!!!!!";
		String errorMessage = "Something went wrong !!!!!!!";
		ResponseEntity<String> response;
		userService.deleteSeller(sellerid);
			response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping(value="/api/buyer/deactivate")
	public ResponseEntity<String> deleteBuyer(@RequestBody BuyerDTO buyerDTO){
		logger.info("Buyer successfully deleted with buyerrid {}", buyerDTO.getBuyerid());
		ResponseEntity<String> response;
		String successMessage = "Buyer deactivated successfully !!!!!!!";
		String errorMessage = "Something went wrong !!!!!!!";
		if(userService.deleteBuyer(buyerDTO.getEmail())) {
			response = new ResponseEntity<String>(successMessage, HttpStatus.OK);	
		}
		else {
			response = new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@DeleteMapping(value="/api/seller/deactivate")
	public ResponseEntity<String> deleteSeller(@RequestBody SellerDTO sellerDTO){
		logger.info("Seller successfully deleted with email {}", sellerDTO.getEmail());
		ResponseEntity<String> response;
		String successMessage = "Seller deactivated successfully !!!!!!!";
		String errorMessage = "Something went wrong !!!!!!!";
		if(userService.deleteSeller(sellerDTO.getEmail())){
			response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		}else {
			response = new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	// adding product to wishlist (Buyer)
	@PostMapping(value = "/api/wishlist/add")
	public ResponseEntity<String> addToWishlist(@RequestBody WishlistDTO wishlistDTO)
	{
		logger.info("Product wishlisted successfully for buyer {}", wishlistDTO);
		ResponseEntity<String> response;
		String successMessage = "Product wishlisted successfully !!!!!!!";
		String errorMessage = "Duplicate product found !!!!!!!";
		if(userService.addBuyerWishlist(wishlistDTO)) {
			response = new ResponseEntity<String>(successMessage, HttpStatus.OK);	
		}else {
			response = new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
	
	//adding product to cart (Buyer)
	@PostMapping(value = "/api/cart/add")
	public ResponseEntity<String> addToCart(@RequestBody CartDTO cartDTO){
		logger.info("Product added to cart successfully for buyer {}",cartDTO);
		ResponseEntity<String>response;
		String successMessage = "Product added to cart successfully !!!!!!!";
		String errorMessage = "Duplicate entry found !!!!!!!";
		if(userService.addToCart(cartDTO)) {
			response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		}else {
			response = new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	//removing product from wishlist (Buyer)
	@DeleteMapping(value="/api/wishlist/remove")
	public ResponseEntity<String> removeFromWishlist(@RequestBody WishlistDTO wishlistDTO){
		logger.info("Product removed from Wishlist  {}", wishlistDTO);
		ResponseEntity<String> response;
		String successMessage = "Product removed from Wishlist successfully !!!!!!!";
		String errorMessage = "Something went wrong !!!!!!!";
		if(userService.removeProductFromWishlist(wishlistDTO)) {
			response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	//removing product from wishlist (Buyer)
	@DeleteMapping(value="/api/cart/remove")
	public ResponseEntity<String> removeFromCart(@RequestBody CartDTO cartDTO){
		logger.info("Product removed from Cart  {}", cartDTO);
		ResponseEntity<String> response;
		String successMessage = "Product removed from Cart successfully !!!!!!!";
		String errorMessage = "Something went wrong !!!!!!!";
		if(userService.removeProductFromCart(cartDTO)) {
			response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		return response;
	}


}

