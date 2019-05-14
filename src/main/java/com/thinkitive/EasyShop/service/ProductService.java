package com.thinkitive.EasyShop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.thinkitive.EasyShop.model.Product;


public interface ProductService {

	public void createProduct(Product product);

	public Page<Product> getAllProduct(Pageable pagable);

	public Product getById(int id);

	public Product getByProductName(String firstName);

	public Product updateProduct(Product product, int id);

	public void deleteById(int id);

	public void deleteAll();

}

