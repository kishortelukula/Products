package com.product.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.product.entity.AllProducts;
import com.product.entity.ProductFiles;
import com.product.entity.ProductsDeatils;
import com.product.entity.SignUp;
import com.product.repository.SignUpRepo;
import com.product.service.EmailService;
import com.product.service.ProductDetailsService;
import com.product.service.ProductFileService;
import com.product.service.SignUpService;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:3000,http://10.0.2.15:3000/")

public class ProductControllers {

	@Autowired
	ProductDetailsService detailsService;

	@PostMapping("/insert")
	public ResponseEntity<Integer> insertProdDetails(@RequestBody ProductsDeatils deatils) {
		this.detailsService.insertProducts(deatils);
		Integer I = deatils.getProductId();
		return new ResponseEntity<>(I, HttpStatus.OK);

	}

	@GetMapping("/allProducts")
	public ResponseEntity<List<ProductsDeatils>> allproducts() {
		List<ProductsDeatils> l1 = this.detailsService.allDetails();
		return new ResponseEntity<>(l1, HttpStatus.OK);

	}

	@PostMapping("/insertFiles")
	public ResponseEntity<String> insertFiles(@RequestPart("file") MultipartFile files,
			@RequestParam("productId") Integer productId) {
		try {
			String data = this.detailsService.insertFiles(files, productId);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("Exception", HttpStatus.BAD_GATEWAY);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}

	}

	@Autowired
	ProductFileService fileService;

	@PostMapping("/insertFilesandDetails")
	public ResponseEntity<String> insertProdFilesDetails(@RequestBody ProductsDeatils deatils,
			@RequestBody ProductFiles files) {
		this.fileService.saveFilesAndDetails(deatils, files);
		return new ResponseEntity<>("inserted..!", HttpStatus.OK);

	}

	@GetMapping("/all")
	public ResponseEntity<List<AllProducts>> getAllProducts() {
		List<AllProducts> allProducts = detailsService.getAllProducts();
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}

	@GetMapping("/productbyId/{id}")
	public ResponseEntity<AllProducts> getProductById(@PathVariable int id) {
		AllProducts optional = detailsService.getAllbyId(id);

		return new ResponseEntity<AllProducts>(optional, HttpStatus.OK);
	}

	@Autowired
	SignUpService signUpService;

	@PostMapping("/signUpDetails")
	public ResponseEntity<String> insertSignUp(@RequestBody SignUp signUp) {
		String x = this.signUpService.insertSignUpDetails(signUp);
		System.out.println(x);
		return new ResponseEntity<>(x, HttpStatus.OK);
	}

	@Autowired
	EmailService emailService;

	@GetMapping("/sendMail")
	public String sendMail() {
		String to = "gainisaikumarchinna@gmail.com";
		String subject = "Test Email";
		String text = "This is a test email from Spring Boot.";
		emailService.sendEmail(to, subject, text);
		return "Email Sent Successfully!";
	}
	
	@GetMapping
	public String logIn() {
		return null;
		
	}

}
