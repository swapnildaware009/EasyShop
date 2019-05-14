package com.thinkitive.EasyShop.dto;

import com.thinkitive.EasyShop.model.Category;
import com.thinkitive.EasyShop.model.LineItem;
import com.thinkitive.EasyShop.model.Product;

public class LineItemDTO {

	private int lineItemId;
	private int lineItemQuantity;
	private double lineItemPrice;
	private Product product;
	
	private Category category;

	public LineItemDTO(LineItem lineItem) {
		this.lineItemId=lineItem.getLineItemId();
		this.lineItemQuantity=lineItem.getLineItemQuantity();
		this.lineItemQuantity=lineItem.getLineItemQuantity();
		this.product=lineItem.getProduct();
		
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LineItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getLineItemId() {
		return lineItemId;
	}
	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}
	public int getLineItemQuantity() {
		return lineItemQuantity;
	}
	public void setLineItemQuantity(int lineItemQuantity) {
		this.lineItemQuantity = lineItemQuantity;
	}
	public double getLineItemPrice() {
		return lineItemPrice;
	}
	public void setLineItemPrice(double lineItemPrice) {
		this.lineItemPrice = lineItemPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
