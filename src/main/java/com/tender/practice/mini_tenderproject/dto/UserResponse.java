package com.tender.practice.mini_tenderproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserResponse {
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private String role;

}
