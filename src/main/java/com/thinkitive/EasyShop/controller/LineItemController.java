package com.thinkitive.EasyShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.EasyShop.dto.LineItemDTO;
import com.thinkitive.EasyShop.model.LineItem;
import com.thinkitive.EasyShop.service.LineItemService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/lineItem")
public class LineItemController {

	@Autowired
	LineItemService lineItemService; 
	
	@PostMapping("/create")
	public ResponseEntity<Void> createLineItem(@RequestBody LineItemDTO lineItemDTO)
	{
		LineItem lineItem=new LineItem(lineItemDTO);
		
		if(lineItem==null) 
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else
		{
			lineItemService.createLimeItem(lineItem);
			return new ResponseEntity<Void>(HttpStatus.CREATED);

		}
		
		
	}
	
}
