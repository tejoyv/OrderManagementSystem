package com.project.User.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.project.User.dto.BuyerDTO;
import com.project.User.dto.SellerDTO;
import com.project.User.service.UserMSException;

@Component
public class Validator {
	
	@Autowired
	Environment environment;
	
	public void validateBuyer(BuyerDTO buyer) throws UserMSException {
		if(!validateName(buyer.getName())) {
			throw new UserMSException(environment.getProperty("INVALID_NAME"));
		}
		if(!validateEmail(buyer.getEmail())){
			throw new UserMSException(environment.getProperty("INVALID_EMAIL"));
		}
		if(!validatePassword(buyer.getPassword())) {
			throw new UserMSException(environment.getProperty("INVALID_PASSWORD"));
		}
		if(!validatePhoneNumber(buyer.getPhoneNumber())) {
			throw new UserMSException(environment.getProperty("INVALID_PHONENUMBER"));
		}
		
	}
	
	public void validateSeller(SellerDTO seller) throws UserMSException {
		if(!validateName(seller.getName())) {
			throw new UserMSException(environment.getProperty("INVALID_NAME"));
		}
		if(!validateEmail(seller.getEmail())){
			throw new UserMSException(environment.getProperty("INVALID_EMAIL"));
		}
		if(!validatePassword(seller.getPassword())) {
			throw new UserMSException(environment.getProperty("INVALID_PASSWORD"));
		}
		if(!validatePhoneNumber(seller.getPhoneNumber())) {
			throw new UserMSException(environment.getProperty("INVALID_PHONENUMBER"));
		}
		
	}
	
	public static boolean validateName(String name) throws UserMSException {
		String regex="([A-Za-z]+\\s?)+[^@#$%^&*_!0-9. ]";
		 if(name.matches(regex)){
	            return true;
	        }
		 else
			   return false;
	}
	
	public static boolean validateEmail(String email) throws UserMSException {
		String regex = "[a-zA-Z0-9]+@[a-zA-Z]+\\.com";
		 if(email.matches(regex)){
	            return true;
	        }
		 else
			   return false;
	}
	
	public static boolean validatePassword(String password) throws UserMSException{
		String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
		if(password.matches(regex)) {
			return true;
		}
		else 
		    return false;
	}
	
	public static boolean validatePhoneNumber(String phoneNumber) throws UserMSException {
		 String regex="[0-9]{10}";
		 if(phoneNumber.matches(regex)) {
			 return true;
		 }
		 else 
			 return false;
	}
	
	public static boolean validateRewardPointsForPrivilege(int rewardPoints) throws UserMSException {
		 if(rewardPoints>=10000)
		    return true;
		 else
			 return false;
	}

}
