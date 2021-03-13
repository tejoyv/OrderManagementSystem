package com.project.User;

import java.util.ArrayList;


import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Any;
import com.project.User.dto.BuyerDTO;
import com.project.User.dto.SellerDTO;
import com.project.User.entity.Buyer;
import com.project.User.entity.Seller;
import com.project.User.repository.BuyerRepository;
import com.project.User.repository.SellerRepository;
import com.project.User.service.UserService;
import com.sun.el.stream.Optional;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class UserApplicationTests {
	
    @Mock
	BuyerRepository buyerRepository;
    
    @Mock
    SellerRepository sellerRepository;
	
    @InjectMocks
    UserService service= new UserService();
	
	@Test
	public void authenticateBuyerLoginDetailsValid () throws Exception {
		BuyerDTO b = new BuyerDTO();
		b.setEmail("ankita");
		b.setPassword("123");
		Mockito.when(buyerRepository.findByEMAIL("ankita")).thenReturn(b.createEntity());
		Boolean actual = service.loginBuyer(b);
		Assertions.assertEquals(true, actual);
		 
	}
//	@Test
//	public void authenticateBuyerLoginDetailsInValid() throws Exception {
//		BuyerDTO b = new BuyerDTO();
//		b.setEmail("veer");
//		b.setPassword("123");
//		
//		BuyerDTO repo = new BuyerDTO();
//		repo.setEmail("ankita");
//		repo.setPassword("123");
//		
//		Mockito.when(buyerRepository.findByEMAIL("ankita")).thenReturn(repo.createEntity());
//	    Exception exception=Assertions.assertThrows(Exception.class,()->service.loginBuyer(b));
//		Assertions.assertEquals("UserService.INVALID_LOGIN", exception.getMessage());
//	}
	
	@Test
	public void authenticateSellerLoginDetailsValid() throws Exception {
		SellerDTO s = new SellerDTO();
		s.setEmail("ankita");
		s.setPassword("123");
		Mockito.when(sellerRepository.findByEMAIL("ankita")).thenReturn(s.createEntity());
		Boolean actual = service.loginSeller(s);
		Assertions.assertEquals(true, actual);
	}

	@Test
	public void getAllBuyersValid() {
		Buyer buyer=new Buyer(1,"saurabh kumar","saurabh@gmail.com","7777766666","Kumar@w*3996",0,0,1);
		Buyer buyer1=new Buyer(2,"aditya","aditya@gmail.com","7777766645","aditya",0,0,1);		
		
		List<Buyer> buyers = new ArrayList<>();
		buyers.add(buyer);
		buyers.add(buyer1);
		
		Mockito.when(buyerRepository.findAll()).thenReturn(buyers);
		List<BuyerDTO> actual = service.getAllBuyers();
		Assertions.assertEquals(buyers.isEmpty(), actual.isEmpty());
		
	}
	
	@Test
	public void getAllSellersValid() {
		Seller seller=new Seller(1,"saurabh kumar","saurabh@gmail.com","7777766666","Kumar@w*3996",0);
		Seller seller1=new Seller(2,"aditya","aditya@gmail.com","7777766645","aditya",0);		
		
		List<Seller> sellers = new ArrayList<>();
		sellers.add(seller);
		sellers.add(seller1);
		
		Mockito.when(sellerRepository.findAll()).thenReturn(sellers);
		List<SellerDTO> actual = service.getAllSellers();
		Assertions.assertEquals(sellers.isEmpty(), actual.isEmpty());
		
	}
	
//	@Test
//	public void getAllSellersInValid() {		
//		
//		List<Seller> sellers = null;
//		Mockito.when(sellerRepository.findAll()).thenReturn(null);
//		List<SellerDTO> actual = service.getAllSellers();
//		Assertions.assertEquals(true, actual.isEmpty());
//		
//	}
	
	@Test
	public void deleteBuyerByIdValid() {
		int id =1;
		service.deleteBuyer(id);
		verify(buyerRepository, times(1)).deleteById(id);
	}
	
	@Test
	public void deleteSellerByIdValid() {
		int id =1;
		service.deleteSeller(id);
		verify(sellerRepository, times(1)).deleteById(id);
	}
	
	@Test
	public void deleteBuyerByEmailValid(){
		BuyerDTO b = new BuyerDTO();
		b.setEmail("ankita");
		
		Mockito.when(buyerRepository.findByEMAIL("ankita")).thenReturn(b.createEntity());
		Boolean actual=service.deleteBuyer("ankita");
		Assertions.assertEquals(true, actual);
	}
	
	@Test
	public void deleteBuyerByEmailInValid(){
		
		Mockito.when(buyerRepository.findByEMAIL("ankita")).thenReturn(null);
		Boolean actual=service.deleteBuyer("ankita");
		Assertions.assertEquals(false, actual);
	}
	
	@Test
	public void deleteSellerByEmailValid(){
		SellerDTO b = new SellerDTO();
		b.setEmail("ankita");
		
		Mockito.when(sellerRepository.findByEMAIL("ankita")).thenReturn(b.createEntity());
		Boolean actual=service.deleteSeller("ankita");
		Assertions.assertEquals(true, actual);
	}
	
	@Test
	public void deleteSellerByEmailInValid(){
		
		Mockito.when(sellerRepository.findByEMAIL("ankita")).thenReturn(null);
		Boolean actual=service.deleteSeller("ankita");
		Assertions.assertEquals(false, actual);
	}
}
