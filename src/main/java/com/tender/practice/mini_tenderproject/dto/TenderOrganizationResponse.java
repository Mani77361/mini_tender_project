package com.tender.practice.mini_tenderproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TenderOrganizationResponse {
	
	private String tenderNumber;
	
	private String title;
	
	private String status;
	
	private String Organizationname;
	
	private String department;

}
