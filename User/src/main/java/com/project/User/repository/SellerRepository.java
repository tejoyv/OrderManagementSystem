package com.project.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.User.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer>{
	public Seller findByEMAIL(String email);
}
