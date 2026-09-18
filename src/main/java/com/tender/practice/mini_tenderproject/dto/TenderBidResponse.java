package com.tender.practice.mini_tenderproject.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenderBidResponse {
		private String tenderNumber;
		
		private String title;
		
		private String status;
		
		private BigDecimal estimated_value;
		
		private String organization_name;
		
		private String department;
	
	    private Long totalItems;
	
	    private Long totalBids;
	    
	    private BigDecimal lowestBidAmount;
	    
	    private BigDecimal highestBidAmount;
	
	
}
