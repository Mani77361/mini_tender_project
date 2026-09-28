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
public class tenderItemOrganizationBidsResponse {

	private Long id;
	
	private String tenderNumber;
	
	private String title;
	
	private String status;
	
	private BigDecimal estimatedValue;
	
	private String organizationName;
	
	private String department;
	
	private Long totalItem;
	
	private Long totalBids;
	
	private BigDecimal lowestBid;
	
	private BigDecimal highestBid;
	
	
	
}
