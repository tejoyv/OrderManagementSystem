package com.project.User.Validator;

import com.project.User.dto.BuyerDTO;
import com.project.User.dto.SellerDTO;


public class Validator {
	public static void validateBuyer(BuyerDTO buyer) throws Exception {
		if(!validateName(buyer.getName())) {
			throw new Exception("Validator.INVALID_NAME");
		}
		if(!validateEmail(buyer.getEmail())){
			throw new Exception("Validator.INVALID_EMAIL");
		}
		if(!validatePassword(buyer.getPassword())) {
			throw new Exception("Validator.INVALID_PASSWORD");
		}
		if(!validatePhoneNumber(buyer.getPhoneNumber())) {
			throw new Exception("Validator.INVALID_PHONENUMBER");
		}
		
	}
	
	public static void validateSeller(SellerDTO seller) throws Exception {
		if(!validateName(seller.getName())) {
			throw new Exception("Validator.INVALID_NAME");
		}
		if(!validateEmail(seller.getEmail())){
			throw new Exception("Validator.INVALID_EMAIL");
		}
		if(!validatePassword(seller.getPassword())) {
			throw new Exception("Validator.INVALID_PASSWORD");
		}
		if(!validatePhoneNumber(seller.getPhoneNumber())) {
			throw new Exception("Validator.INVALID_PHONENUMBER");
		}
		
	}
	
	public static boolean validateName(String name) throws Exception {
		String regex="([A-Za-z]+\\s?)+[^@#$%^&*_!0-9. ]";
		 if(name.matches(regex)){
	            return true;
	        }
		 else
			   return false;
	}
	
	public static boolean validateEmail(String email) throws Exception {
		String regex = "[a-zA-Z0-9]+@[a-zA-Z]+\\.com";
		 if(email.matches(regex)){
	            return true;
	        }
		 else
			   return false;
	}
	
	public static boolean validatePassword(String password) throws Exception{
		String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8, 20}$";
		if(password.matches(regex)) {
			return true;
		}
		else 
		    return false;
	}
	
	public static boolean validatePhoneNumber(String phoneNumber) throws Exception {
		 String regex="[0-9]{10}";
		 if(phoneNumber.matches(regex)) {
			 return true;
		 }
		 else 
			 return false;
	}
}