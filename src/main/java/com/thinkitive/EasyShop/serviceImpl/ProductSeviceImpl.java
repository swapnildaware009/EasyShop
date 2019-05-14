package com.thinkitive.EasyShop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thinkitive.EasyShop.model.Product;
import com.thinkitive.EasyShop.repository.ProductRepository;
import com.thinkitive.EasyShop.service.ProductService;

@Service
public class ProductSeviceImpl implements ProductService {
	
	

	@Autowired
	ProductRepository productRepository;

	@Override
	public void createProduct(Product product) {
		
		

		productRepository.save(product);
	}

	@Override
	public Product getById(int id) {
		return productRepository.getOne(id);
	}

	@Override
	public Product updateProduct(Product product, int id) {
		return productRepository.save(product);
	}

	@Override
	public void deleteById(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
	}

	@Override
	public Product getByProductName(String productName) {

		System.out.println("product list :::" + productRepository.getProductByProductName(productName));

		return productRepository.getProductByProductName(productName);
	}

	@Override
	public Page<Product> getAllProduct(Pageable pagable) {
		System.out.println("Before repo");
		return productRepository.findAll(pagable);
	}
	
	

}
