package com.thinkitive.EasyShop.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkitive.EasyShop.dto.LineItemDTO;

@Entity
@Table(name="lineItem")
@Proxy(lazy = false)
public class LineItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int lineItemId;
	
	private int lineItemQuantity;
	private double lineItemPrice;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Product product;
	 
	
	
	public LineItem() {
		super();
	}

	public LineItem(LineItemDTO lineItemDTO) {
		this.lineItemId=lineItemDTO.getLineItemId();
		this.lineItemQuantity=lineItemDTO.getLineItemQuantity();
		this.lineItemQuantity=lineItemDTO.getLineItemQuantity();
		this.product=lineItemDTO.getProduct();
		
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
