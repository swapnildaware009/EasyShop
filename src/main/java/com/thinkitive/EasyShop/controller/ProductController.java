/*package com.thinkitive.EasyShop.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thinkitive.EasyShop.dto.ProductDTO;
import com.thinkitive.EasyShop.model.Category;
import com.thinkitive.EasyShop.model.Product;
//import com.thinkitive.EasyShop.service.ProductImagService;
import com.thinkitive.EasyShop.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {
Path fileStorageLocation;
	
	
	
@Autowired
ProductService productService; 
	
//	@Autowired
//	ProductImagService productImagService;

	@PostMapping(value = "/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> createProductList(@RequestBody ProductDTO productDTO) {
		System.out.println(productDTO.getProductId());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Product product = new Product(productDTO);
		if (productDTO == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			productService.createProduct(product);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	
	
	
	
	@PostMapping(value = "/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> create(
			@RequestParam("filename") List<MultipartFile> files) throws Exception
	{
		System.out.println("Createing new products" );
	   

		try {
		for (MultipartFile multipartFile : files) {
			System.out.println("Multipart file {} "+ multipartFile.getOriginalFilename());
	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	        if(fileName.contains("..")) {
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }
	        else {
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = Paths.get("/home/fidel116/swap/EasyShop/uploadImage/"+fileName);
            Files.copy(multipartFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
	       
	        }
	        
		}
		
//		ProductDTO productResponse=new ProductDTO();
//		Date createdDate = new Date();
//	 ObjectMapper mapper=new ObjectMapper();
	  
//		ProductDTO productDTO_request=mapper.readValue(productRequest, ProductDTO.class);
//		List<MultipartFile> imeges=new ArrayList<MultipartFile>();
//			
//		for(MultipartFile file : files) {
//			imeges.add(file);
////			String filename=productImagService.storeFile(file);
//			
//			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//	                .path("/UploadFile/")
////	                .path(filename)
//	                .toString();
//	         
//		}
		

		
//		Product product=new Product(productDTO_request);
//		
//		product.setLineItem(productDTO_request.getLineItem());
//		product.setCategory(productDTO_request.getCategory());
//		product.setProductCode(productDTO_request.getProductCode());
//		product.setProductDescription(productDTO_request.getProductDescription());
//		product.setProductLastUpdate(createdDate);
//		product.setProductName(productDTO_request.getProductName());
//		product.setProductPrice(productDTO_request.getProductPrice());
//		product.setProductQuantity(productDTO_request.getProductQuantity());
//		
//		productService.createProduct(product);
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	} catch (Exception e) {
		
		
		e.printStackTrace();
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	} 	
	}
	

	public ProductController() {
		super();
		// TODO Auto-generated constructor stub
	}


	@GetMapping("/getAll")
	Page<Product> getAllProduct(Pageable pagable) {
		return productService.getAllProduct(pagable);
	}
	

	
	 @GetMapping("/getAll") List<Product> getAllProduct() { return
	  productService.getAllProduct(); 
	 }
	 

	@GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id) throws Exception {
		System.out.println("id ::::" + id);

		Product product = productService.getById(id);
		if (product == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		} else {
			System.out.println("Product==> GetById " + id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/getByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Product> getProductByName(@PathVariable("name") String name) throws Exception {
		System.out.println("name ::::" + name);
		Product product = productService.getByProductName(name);
		Category category = product.getCategory();
		System.out.println("((((((((((((((((((()))))))))))))))))))))" + category);
		Product product1 = new Product();
		product1 = product;
		product1.setCategory(category);
		;
		if (product1 == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		} else {
			System.out.println("Product==> GetByName " + name);
			return new ResponseEntity<Product>(product1, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/deleteById/{productId}")
	public ResponseEntity<Product> deleteProductById(@PathVariable("productId") int productId) {

		Product product = productService.getById(productId);
		if (product == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		} else {
			productService.deleteById(productId);
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping(value = "/deleteAll")
	public ResponseEntity<Product> deleteAllCategory() {

		productService.deleteAll();
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);

	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<Product> updateProduct(@RequestBody ProductDTO productDTO) {
		Product product = new Product(productDTO);

		Product product1 = productService.getById(product.getProductId());
		if (product1 == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		} else {
			product1.setProductId(productDTO.getProductId());
			product1.setProductName(productDTO.getProductName());
			product1.setProductDescription(productDTO.getProductDescription());
			product1.setProductCode(productDTO.getProductCode());
			product1.setProductLastUpdate(productDTO.getProductLastUpdate());
			product1.setProductPrice(productDTO.getProductPrice());
			product1.setProductQuantity(productDTO.getProductQuantity());
			productService.updateProduct(product1, productDTO.getProductId());

			return new ResponseEntity<Product>(product1, HttpStatus.CREATED);

		}
	}
	
	
	
}
*/