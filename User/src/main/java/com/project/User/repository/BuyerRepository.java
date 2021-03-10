package com.project.User.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.User.entity.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Integer>{
     
}
