package com.tender.practice.mini_tenderproject.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenderItemViewResponse {
	
	private Long tenderId;
	
	private Long tenderItemId;
	
	private String tenderName;
	
	private LocalDate publishDate;

	private Integer quantity;
	
	private BigDecimal unitPrice;
}
