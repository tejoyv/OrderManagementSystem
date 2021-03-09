package com.project.Product.service;

import java.util.List;

import com.project.Project.dto.ProductDTO;

public interface ProductService {
	public List<ProductDTO> getAllProducts() throws ProductMSException;
}
