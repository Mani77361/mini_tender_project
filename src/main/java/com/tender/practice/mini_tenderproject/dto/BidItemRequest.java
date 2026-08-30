package com.tender.practice.mini_tenderproject.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BidItemRequest {
	
	@NotNull(message = "Bid Id Must Be Required")
	private Long bidId;
	
	@NotNull(message = "TenderItemId Must Be Required")
	private Long tenderItemId;

	@NotBlank(message = "UnitPrice Must Be Required")
	private BigDecimal unitPrice;
	
	@NotBlank(message = "Quantity Must Be Required")
	private Integer quantity;
	
	@NotBlank(message = "TotalPrice MUst Be Required")
	private BigDecimal totalPrice;
	
}
