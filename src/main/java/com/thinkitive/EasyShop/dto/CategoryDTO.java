package com.thinkitive.EasyShop.dto;

import java.util.Date;
import java.util.List;

import com.thinkitive.EasyShop.model.Category;
import com.thinkitive.EasyShop.model.Product;

public class CategoryDTO {

	private int categoryid;
	private String categoryName;
	private String categoryDescription;
	private Date lastUpdate;

	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CategoryDTO(Category category) {
		this.categoryid = category.getCategoryid();
		this.categoryName = category.getCategoryName();
		this.categoryDescription = category.getCategoryDescription();
		this.lastUpdate = category.getLastUpdate();
		this.product = category.getProduct();
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {

		this.lastUpdate = lastUpdate;
	}

	public CategoryDTO() {
		super();
	}

}
