package com.tender.practice.mini_tenderproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tender.practice.mini_tenderproject.dto.ForgotPasswordRequest;
import com.tender.practice.mini_tenderproject.service.AuthService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthService authService;
	
	public AuthController(AuthService authService) {
		
		this.authService =authService;
	
		
	}
	
	@GetMapping("forgot-password")
	public ResponseEntity<String> forgotUserPassword(@RequestBody ForgotPasswordRequest request){
		
		
		return ResponseEntity.ok("Password Reset Password Started");
		
		
	}
	
}
