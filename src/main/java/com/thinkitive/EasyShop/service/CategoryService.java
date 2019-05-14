package com.thinkitive.EasyShop.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.thinkitive.EasyShop.model.Category;

public interface CategoryService {

	public void createCategory(Category category);
	public List<Category> getAllCategory();
	public Category getCategoryByCategoryId(int id);
	public Category getCategoryByCategoryName(String categoryName);
	public Category updateCategory(Category category, int categoryId);
	public void deleteCategoryById(int categoryId);
	public void deleteAllCategory();
	public Page<Category> getAllCategory(Pageable pageable);
	
}
