package com.thinkitive.EasyShop.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkitive.EasyShop.dto.CategoryDTO;

@Entity
@Table(name="category")
@Proxy(lazy = false)
public class Category implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryid;
	
	@NotBlank
    @Size(min=3, max = 50)
	private String categoryName;
	
	@NotBlank
    @Size(min=10, max = 500)
	private String categoryDescription;
	
    
	private Date lastUpdate;

	@OneToOne(mappedBy="category")
	@JsonIgnore
	private Product product;
	

	


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
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


	public Category() {
		super();
	}
	public Category(CategoryDTO categoryDTO ) {
		this.categoryid=categoryDTO.getCategoryid();
		this.categoryName=categoryDTO.getCategoryName();
		this.categoryDescription=categoryDTO.getCategoryDescription();
		this.lastUpdate=categoryDTO.getLastUpdate();
		this.product=categoryDTO.getProduct();
	}

	public Category(int categoryid, @NotBlank @Size(min = 3, max = 50) String categoryName,
			@NotBlank @Size(min = 10, max = 500) String categoryDescription, Date lastUpdate) {
		super();
		this.categoryid = categoryid;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.lastUpdate = lastUpdate;
	}


/*	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", lastUpdate=" + lastUpdate + "]";
	}
	*/
	
	
	
	
	
}
