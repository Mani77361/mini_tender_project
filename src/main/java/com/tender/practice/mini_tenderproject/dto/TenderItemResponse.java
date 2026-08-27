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
public class TenderItemResponse {
	
	private Long tenderItemId;
	
	private Long tenderId;
	
	private String itemName;
	
	private String description;
	
	private Integer quantity;
	
	private String unit;
	
	private BigDecimal unitPrice;

}
