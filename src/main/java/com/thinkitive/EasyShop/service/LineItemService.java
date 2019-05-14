package com.thinkitive.EasyShop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.thinkitive.EasyShop.dto.LineItemDTO;
import com.thinkitive.EasyShop.model.LineItem;

public interface LineItemService {

	public void createLimeItem(LineItem lineItem );

	public Page<LineItem> getAllLineItem(Pageable pageable);

	public LineItem getById(int lineItemId);

	public LineItem updateLineItem(LineItem lineItem, int lineItemId);

	public void deleteById(int lineItemId);

	public void deleteAll();
	
}
