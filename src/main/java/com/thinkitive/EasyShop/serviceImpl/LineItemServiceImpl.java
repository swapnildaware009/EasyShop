package com.thinkitive.EasyShop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thinkitive.EasyShop.model.LineItem;
import com.thinkitive.EasyShop.repository.LineItemRepository;
import com.thinkitive.EasyShop.service.LineItemService;

@Service
public class LineItemServiceImpl implements LineItemService {

	@Autowired
	LineItemRepository lineItemRepository; 
	
	

	@Override
	public Page<LineItem> getAllLineItem(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LineItem getById(int lineItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LineItem updateLineItem(LineItem lineItem, int lineItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int lineItemId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createLimeItem(LineItem lineItem) {
		lineItemRepository.save(lineItem);
	}

}
