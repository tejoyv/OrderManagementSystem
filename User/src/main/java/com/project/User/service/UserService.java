package com.project.User.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.project.User.Validator.Validator;
import com.project.User.dto.BuyerDTO;
import com.project.User.dto.SellerDTO;
import com.project.User.entity.Buyer;
import com.project.User.entity.Seller;
import com.project.User.repository.BuyerRepository;
import com.project.User.repository.SellerRepository;

@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BuyerRepository buyerRepository;
	
	@Autowired
	SellerRepository sellerRepository;
	
	@Autowired
	Environment environment;
	
	public void registerBuyer(BuyerDTO buyerDTO) {
		logger.info("Register request for buyer {}", buyerDTO);
		Buyer buyer = buyerDTO.createEntity();
		buyerRepository.save(buyer);
	}
	public void registerSeller(SellerDTO sellerDTO) {
		logger.info("Register request for buyer {}", sellerDTO);
		Seller seller = sellerDTO.createEntity();
		sellerRepository.save(seller);
	}
	
	//login buyer
	public boolean loginBuyer(BuyerDTO buyerDTO) throws Exception {
		logger.info("Login request for buyer {} with buyerid {}", buyerDTO.getEmail());
		boolean status=false;
		Buyer buyer = buyerRepository.findByEMAIL(buyerDTO.getEmail());
		if(buyer!=null) {
			System.out.println("Print");
			//Buyer buyer1 = buyer.get();
			if (buyer.getPassword().equals(buyerDTO.getPassword())) {
				status=true;
			}else {
				status=false;
			}
		}
		if(status==true) {
			logger.info("Successfully login");
		}else {
			logger.info(environment.getProperty("UserService.INVALID_LOGIN"));
		}
		return status;
	}
	//login seller
	public boolean loginSeller(SellerDTO sellerDTO) throws Exception {
			logger.info("Login request for buyer {} with sellerid {}", sellerDTO.getEmail());
			boolean status=false;
			Seller seller = sellerRepository.findByEMAIL(sellerDTO.getEmail());
			if(seller!=null) {
				System.out.println("Print");
				if (seller.getPassword().equals(sellerDTO.getPassword())) {
					status=true;
				}else {
					status=false;
				}
			}
			
			if(status==true) {
				logger.info("Successfully login");
			}else {
				logger.info(environment.getProperty("UserService.INVALID_LOGIN"));
			}
			return status;
	}
	
	//fetch all buyers
	public List<BuyerDTO> getAllBuyers(){
		List<Buyer> buyer = buyerRepository.findAll();
		List<BuyerDTO> buyerDTOs = new ArrayList<>();
		for(Buyer b:buyer) {
			BuyerDTO buyerDTO = BuyerDTO.valueOf(b);
			buyerDTOs.add(buyerDTO);
		}
		return buyerDTOs;
	}
	
	//fetch all sellers
	public List<SellerDTO> getAllSellers(){
		List<Seller> seller = sellerRepository.findAll();
		List<SellerDTO> sellerDTOs = new ArrayList<>();
		for(Seller s:seller) {
			SellerDTO sellerDTO = SellerDTO.valueOf(s);
			sellerDTOs.add(sellerDTO);
		}
		return sellerDTOs;
	}
	
}
