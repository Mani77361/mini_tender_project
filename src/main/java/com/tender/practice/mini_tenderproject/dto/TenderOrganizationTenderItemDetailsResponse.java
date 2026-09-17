package com.tender.practice.mini_tenderproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenderOrganizationTenderItemDetailsResponse {
	
	private String tenderNumber;
	
	private String title;
	
	private String status;
	
	private String Organizationname;
	
	private String department;
	
	private String itemName;
	
	private String description;
	
	private Integer quantity;
	
}
