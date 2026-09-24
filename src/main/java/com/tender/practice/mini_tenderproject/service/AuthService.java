package com.tender.practice.mini_tenderproject.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tender.practice.mini_tenderproject.entity.User;
import com.tender.practice.mini_tenderproject.repository.UserRepository;

@Service
public class AuthService {
	
	/*
	 * private final UserRepository userRepository;
	 * 
	 * public AuthService(UserRepository userRepository) {
	 * 
	 * this.userRepository = userRepository; }
	 * 
	 * public String forgotPassword(String email) {
	 * 
	 * Optional<User> userOptional = userRepository.findByEmail(email);
	 * 
	 * if(userOptional.isEmpty()) { return "no email found"; }
	 * 
	 * User user = userOptional.get(); System.out.println("Reset Password For :" +
	 * user.getEmail()); return email;
	 * 
	 * 
	 * }
	 */

}
