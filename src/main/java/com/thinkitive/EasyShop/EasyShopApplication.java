package com.thinkitive.EasyShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.thinkitive.EasyShop.model.StorageProperties;

@CrossOrigin
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class EasyShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyShopApplication.class, args);
	}

}
