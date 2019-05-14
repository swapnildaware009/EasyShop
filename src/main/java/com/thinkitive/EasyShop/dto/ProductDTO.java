package com.thinkitive.EasyShop.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.thinkitive.EasyShop.model.Category;
import com.thinkitive.EasyShop.model.LineItem;
import com.thinkitive.EasyShop.model.Product;
import com.thinkitive.EasyShop.model.ProductImage;

public class ProductDTO {
	private int productId;
	private String productName;
	private String productCode;
	private String productDescription;
	List<ProductImage> image;

	private Date productLastUpdate;
	private double productPrice;
	private int productQuantity;
	private Category category;
	private LineItem lineItem;

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

	

	public List<ProductImage> getImage() {
		return image;
	}

	public void setImage(List<ProductImage> image) {
		this.image = image;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LineItem getLineItem() {
		return lineItem;
	}

	public void setLineItem(LineItem lineItem) {
		this.lineItem = lineItem;
	}

	public ProductDTO(Product product) {
		this.productId = product.getProductId();
		this.productName = product.getProductName();
		this.productDescription = product.getProductDescription();
		this.productCode = product.getProductCode();
		this.productLastUpdate = product.getProductLastUpdate();
		this.productPrice = product.getProductPrice();
		this.productQuantity = product.getProductQuantity();
		this.category = product.getCategory();
		this.lineItem = product.getLineItem();
		this.image=product.getImage();
	}

	public ProductDTO() {
		super();
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productCode=" + productCode
				+ ", productDescription=" + productDescription + ", image=" + image + ", productLastUpdate="
				+ productLastUpdate + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity
				+ ", category=" + category + ", lineItem=" + lineItem + "]";
	}

}
