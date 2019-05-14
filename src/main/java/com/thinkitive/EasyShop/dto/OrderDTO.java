package com.thinkitive.EasyShop.dto;

import java.util.Date;
import java.util.List;

import com.thinkitive.EasyShop.model.LineItem;

public class OrderDTO {
	private int orderId;

    private Date orderDate;
    
    private String orderStatus;
    
    private double orderAmount;
    
    private List<LineItem> lineItem;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public List<LineItem> getLineItem() {
		return lineItem;
	}

	public void setLineItem(List<LineItem> lineItem) {
		this.lineItem = lineItem;
	}

	public OrderDTO() {
		super();
	}
    
    
}
