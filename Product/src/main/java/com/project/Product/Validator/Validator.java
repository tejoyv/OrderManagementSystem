package com.project.Product.Validator;

import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.Product.dto.ProductDTO;

@Component
public class Validator {
	
	@Autowired
	Environment environment;
	

	public void validateProduct(ProductDTO product) throws Exception {
		if(!validateName(product.getPRODUCTNAME())) {
			throw new Exception(environment.getProperty("INVALID_NAME"));
		}
		if(!validateDescription(product.getDESCRIPTION())){
			throw new Exception(environment.getProperty("INVALID_DESCRIPTION"));
		}
		if(!validatePrice(product.getPRICE())) {
			throw new Exception(environment.getProperty("INVALID_PRICE"));
		}
		if(!validateStock(product.getSTOCK())) {
			throw new Exception(environment.getProperty("INVALID_STOCK"));
		}
		if(!validateImage(product.getIMAGE())) {
			throw new Exception(environment.getProperty("INVALID_IMAGE"));
		}
   }

	public static boolean validateImage(String image) {
		int len = image.length(); 
		String imageType1 =image.substring(len-5,len-1);
		String imageType2 =image.substring(len-4,len-1);
		if(imageType1.equals("jpeg") || imageType2.equals("png")) {
			return true;
		}
		return false;
	}

	private static boolean validateStock(int stock) {
	  if(stock>=10)
		return true;
	  else
		return false;
	}

	private static boolean validatePrice(double price) {
		if(price>=200)
			return true;
		  else
			return false;
	}


	private static boolean validateDescription(String description) {
	    if(description.length()<=500)
		    return true;
	    else
	    	return false;
	}


	private static boolean validateName(String productname) {
		String regex="([A-Za-z]+\\s?)+[^@#$%^&*_!0-9. ]";
		 if(productname.matches(regex) && productname.length()<=100){
	            return true;
	        }
		 else
			   return false;
	}
	
	
}

