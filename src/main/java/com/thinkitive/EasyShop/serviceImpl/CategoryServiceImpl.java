package com.thinkitive.EasyShop.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thinkitive.EasyShop.model.Category;
import com.thinkitive.EasyShop.repository.CategoryRepository;
import com.thinkitive.EasyShop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public void createCategory(Category category) {
		categoryRepository.save(category);

	}

	@Override
	public List<Category> getAllCategory() {
		
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryByCategoryId(int id) {
		
		return categoryRepository.getOne(id);
	}


	@Override
	public void deleteCategoryById(int categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public void deleteAllCategory() {
		categoryRepository.deleteAll();

	}

	
	@Override
	public Category getCategoryByCategoryName(String categoryName) {
		
		return categoryRepository.getAllCategoryByCategoryName(categoryName);
	}

	@Override
	public Category updateCategory(Category category, int categoryId) {
		
		return categoryRepository.save(category);
	}

	@Override
	public Page<Category> getAllCategory(Pageable pageable) {
		
		return categoryRepository.findAll(pageable);
	}

	

}
