package com.thinkitive.EasyShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkitive.EasyShop.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	

	Category getAllCategoryByCategoryName(String categoryName);


	
	
}
