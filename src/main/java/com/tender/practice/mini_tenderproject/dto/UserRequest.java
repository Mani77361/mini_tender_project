package com.tender.practice.mini_tenderproject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserRequest {
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private String role;

}
