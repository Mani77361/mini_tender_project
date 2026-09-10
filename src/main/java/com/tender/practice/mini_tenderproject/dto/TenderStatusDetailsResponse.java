package com.tender.practice.mini_tenderproject.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TenderStatusDetailsResponse {
	
	private Long tenderId;
	
	private String title;
	
	private String description;
	
	private String status;
	
	private Long tenderItemId;
	
	private Integer quantity;

	private String unit;
	
	private BigDecimal price;
}
