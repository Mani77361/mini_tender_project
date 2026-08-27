package com.tender.practice.mini_tenderproject.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data	
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenderResponse {

	private Long id;
	
	private String tenderNumber;
	
	private String title;
	
	private String description;
	
	private String status;
	
	private Long organizationId;
	
	private LocalDate publishDate;
	
	private LocalDate closingDate;
	
	private BigDecimal estimatedValue;
	
	
}
