package com.thinkitive.EasyShop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkitive.EasyShop.dto.ProductDTO;

@Entity
@Table(name = "product")
@Proxy(lazy = false)
public class Product {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;

	@NotBlank
	@Size(min = 3, max = 50)
	private String productName;

	@NotBlank
	@Size(min = 3, max = 50)
	private String productCode;

	@NotBlank
	@Size(min = 3, max = 500)
	private String productDescription;


	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="productId")
	List<ProductImage> image=new ArrayList<>();
	
	

	
	public List<ProductImage> getImage() {
		return image;
	}

	public void setImage(List<ProductImage> image) {
		this.image = image;
	}

	private Date productLastUpdate;

	private double productPrice;

	private int productQuantity;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "product")
	@JsonIgnore
	private LineItem lineItem;

	public LineItem getLineItem() {
		return lineItem;
	}

	public void setLineItem(LineItem lineItem) {
		this.lineItem = lineItem;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Category category;
	
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	
	public Date getProductLastUpdate() {
		return productLastUpdate;
	}

	public void setProductLastUpdate(Date productLastUpdate) {
		this.productLastUpdate = productLastUpdate;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	
	
	
	public Product(int productId, @NotBlank @Size(min = 3, max = 50) String productName,
			@NotBlank @Size(min = 3, max = 50) String productCode,
			@NotBlank @Size(min = 3, max = 500) String productDescription, Date productLastUpdate, double productPrice,
			int productQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCode = productCode;
		this.productDescription = productDescription;
		this.productLastUpdate = productLastUpdate;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}

	public Product(ProductDTO productDTO) {
		this.productId = productDTO.getProductId();
		this.productName = productDTO.getProductName();
		this.productDescription = productDTO.getProductDescription();
		this.productCode = productDTO.getProductCode();
		this.productLastUpdate = productDTO.getProductLastUpdate();
		this.productPrice = productDTO.getProductPrice();
		this.productQuantity = productDTO.getProductQuantity();
		this.category = productDTO.getCategory();
		this.lineItem = productDTO.getLineItem();
		this.image=productDTO.getImage();
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCode=" + productCode
				+ ", productDescription=" + productDescription + ", image=" + image + ", productLastUpdate="
				+ productLastUpdate + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity
				+ ", lineItem=" + lineItem + ", category=" + category + "]";
	}

	public Product() {

		super();
	}

	
}
