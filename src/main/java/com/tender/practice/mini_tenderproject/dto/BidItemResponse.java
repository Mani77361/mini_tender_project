package com.tender.practice.mini_tenderproject.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidItemResponse {

	private Long bidItemId;
	
	private Long bidId;
	
	private Long tenderItemId;
	
	private BigDecimal unitPrice;
	
	private Integer quantity;
	
	private BigDecimal totalPrice;
	
}
