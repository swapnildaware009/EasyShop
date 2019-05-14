//package com.thinkitive.EasyShop.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.thinkitive.EasyShop.model.ProductImage;
//import com.thinkitive.EasyShop.service.ProductImageStorageService;
//
//@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RequestMapping(value = "/image")
//public class ProductImageController {
//
//	@Autowired
//	ProductImageStorageService productImageStorageService;
//	
//	@PostMapping("/uploadFile")
//    @ResponseBody
//    public ProductImage uploadFile(@RequestParam("file") MultipartFile file) {
//        String name = productImageStorageService.store(file);
//
//        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/download/")
//                .path(name)
//                .toUriString();
//
//        return new ProductImage(name, uri, file.getContentType(), file.getSize());
//    }
//	
//}
