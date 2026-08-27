package com.tender.practice.mini_tenderproject.service;

import com.tender.practice.mini_tenderproject.dto.LoginRequest;
import com.tender.practice.mini_tenderproject.dto.UserRequest;
import com.tender.practice.mini_tenderproject.dto.UserResponse;

public interface UserService {
	
		UserResponse createUser(UserRequest request);
		
		UserResponse findUserById(Long id);
		
		UserResponse login(LoginRequest request);
		
}
