package com.project.Product.Validator;

import org.springframework.stereotype.Component;

import com.project.Product.dto.ProductDTO;

@Component
public class Validator {
	
	public static void validateProduct(ProductDTO productDTO) throws Exception {
		
		if(!validateName(productDTO.getPRODUCTNAME())) {
			throw new Exception("Validator.INVALID_NAME");
		}		
		if(productDTO.getDESCRIPTION().length() > 500) {
			throw new Exception("Validator.INVALID_DESCRIPTION");
		}
		if(productDTO.getPRICE() < 200) {
			throw new Exception("Validator.INVALID_PRICE");
		}
		if(!validateStock(productDTO.getSTOCK())) {
			throw new Exception("Validator.INVALID_STOCK");
		}
		if(!validateImage(productDTO.getIMAGE())){
			throw new Exception("Validator.INVALID_IMAGE");
		}
		
	}
	
	public static boolean validateName(String productName) {
		int len = productName.length();
		String regex = "[a-zA-Z]+[a-zA-Z' ']+[a-zA-Z]+";
		if(productName.matches(regex) && len <= 100) {
			return true;
		}
		return false;
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
	
	public static boolean validateStock(int stock) {
		if(stock >= 10) {
			return true;
		}
		return false;
	}


}
