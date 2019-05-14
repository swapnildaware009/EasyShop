package com.thinkitive.EasyShop.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.EasyShop.model.ProductImage;
import com.thinkitive.EasyShop.repository.ProductImageRepository;
import com.thinkitive.EasyShop.service.ProductImageService;

@Service
@Transactional
public class ProductImageServiceImpl implements ProductImageService {

	
	@Autowired
	ProductImageRepository productImageRepository;
	
	@Override
	public void saveImage(ProductImage productImage) {
		productImageRepository.save(productImage);
		
	}

	@Override
	public List<ProductImage> getAllImages() {
		
		return productImageRepository.findAll();
	}

	
}
