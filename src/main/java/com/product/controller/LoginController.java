package com.product.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.LogInCredentials;
import com.product.service.SignUpService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class LoginController {
	
	@Autowired
	private SignUpService service;
	
	@GetMapping("/Login")
	public ResponseEntity<Map<String, Object>> logindata(@RequestBody LogInCredentials credentials)
	{
		Map<String, Object> loginResult=this.service.LoinSerivce(credentials);
		return ResponseEntity.ok(loginResult);
	}
	
	

}
