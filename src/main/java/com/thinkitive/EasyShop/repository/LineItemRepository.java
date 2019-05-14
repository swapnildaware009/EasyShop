package com.thinkitive.EasyShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkitive.EasyShop.model.LineItem;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Integer>{

	
}
