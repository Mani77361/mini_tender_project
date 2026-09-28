package com.tender.practice.mini_tenderproject.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TenderBidSatisticsResponse {

	private String tenderNumber;
	
	private String title;
	
	private BigDecimal minAmount;
	
	private BigDecimal maxAmount;
	
	private BigDecimal avrageAmount;
	
}
