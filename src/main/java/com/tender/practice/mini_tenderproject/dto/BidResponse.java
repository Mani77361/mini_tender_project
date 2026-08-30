package com.tender.practice.mini_tenderproject.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BidResponse {

	private Long tenderId;
	
	private Long supplierId;
	
	private String bidNumber;
	
	private BigDecimal bidAmount;
	
	private String status;
	
	private LocalDate submittedDate;
	
	
	
}
