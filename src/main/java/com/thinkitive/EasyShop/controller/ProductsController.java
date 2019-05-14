package com.thinkitive.EasyShop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thinkitive.EasyShop.model.Category;
import com.thinkitive.EasyShop.model.Product;
import com.thinkitive.EasyShop.model.ProductImage;
import com.thinkitive.EasyShop.service.CategoryService;
import com.thinkitive.EasyShop.service.ImageService;
import com.thinkitive.EasyShop.service.ProductImageService;
import com.thinkitive.EasyShop.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductsController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ImageService imageService;

	@Autowired
	ProductImageService productImageService;

	@PostMapping("/{categoryId}/addProduct")
	ResponseEntity<String> saveProduct(@PathVariable(name = "categoryId") Integer categoryId,
			@RequestParam(name = "productName") String productName,
			@RequestParam(name = "productCode") String productCode,
			@RequestParam(name = "productDescription") String productDescription,
			@RequestParam(name = "productLastUpdateDate") String productLastUpdateDate,
			@RequestParam(name = "productPrice") Double productPrice,
			@RequestParam(name = "productQuantity") int productQuantity,
			@RequestParam(name = "productImage") List<MultipartFile> productImages)

	{
		System.out.println(
				"*********************************** Inside Product Controller **********************************");
		
		Category category = categoryService.getCategoryByCategoryId(categoryId);
		int categoryId1 = category.getCategoryid();
		System.out.println(":::::::::::::::::::::::::" + categoryId1);
		Date date = new Date();
		Product product = new Product(categoryId1, productName, productCode, productDescription, date, productPrice,
				productQuantity);
int id=product.getProductId();
		
System.out.println("??????????????????????????????????Product Id????????????????????????::"+id);
		for (MultipartFile multipartFile : productImages) {

			String imagePath = imageService.store(multipartFile);
		
			productService.createProduct(product);

			String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/").path(imagePath)
					.toUriString();

			String originalName = multipartFile.getOriginalFilename();
			String type = multipartFile.getContentType();
			long size = multipartFile.getSize();
			ProductImage productImage1 = new ProductImage(originalName, uri, type, size);
			productImageService.saveImage(productImage1);

			System.out.println("  PRODUCT POJO  " + product);

		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id) throws Exception {
		System.out.println("id ::::" + id);

		Product product = productService.getById(id);

		Product finalProduct=new Product();
		
			if (product == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		} else {
			System.out.println("Customer==> GetById " + id);
			Date updateDate=new Date();
			finalProduct.setCategory(product.getCategory());
			finalProduct.setProductId(product.getProductId());
			finalProduct.setProductCode(product.getProductCode());
			finalProduct.setProductDescription(product.getProductDescription());
			finalProduct.setProductLastUpdate(updateDate);
			finalProduct.setProductName(product.getProductName());
			finalProduct.setProductPrice(product.getProductPrice());
			finalProduct.setImage(product.getImage());
			List<ProductImage> finalList=new ArrayList<>();
			List<ProductImage> imgList=productImageService.getAllImages();
			
			for(ProductImage image : imgList) 
			{
	
				finalList.add(image);
				
			}
			finalProduct.setImage(finalList);
		}
			return new ResponseEntity<>(finalProduct,HttpStatus.OK);
	}

}
