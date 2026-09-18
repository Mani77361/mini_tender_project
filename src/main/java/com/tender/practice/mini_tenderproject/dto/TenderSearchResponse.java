package com.tender.practice.mini_tenderproject.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenderSearchResponse {
	
	private Long tenderId;
	
	private String tenderNumber;
	
	private String title;
	
	private String status;
	
	private BigDecimal estimatedValue;
	
	private String organizationName;
	
	private String departmaent;
	
	private String itemName;
	
	private Integer quantity;

}