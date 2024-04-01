package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
@ComponentScan("com.product.controller")
@ComponentScan("com.product.service")
@ComponentScan("com.product.repository")
@SpringBootApplication

//@EnableMultipart
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

}
