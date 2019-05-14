package com.thinkitive.EasyShop.service;

import java.util.List;

import com.thinkitive.EasyShop.model.ProductImage;

public interface ProductImageService {

	public void saveImage(ProductImage productImage);
	public List<ProductImage> getAllImages();
}
