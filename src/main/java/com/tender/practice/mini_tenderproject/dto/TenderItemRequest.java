package com.tender.practice.mini_tenderproject.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenderItemRequest {
	@NotNull(message = "TenderId Is Required")
	@Positive(message = "id must be possitive")
	private Long tenderId;
	
	@NotBlank(message = "item name must be required")
	@Size(max = 30 , message ="name below 30 letters" )
	private String itemName;
	
	@NotBlank(message = "description must be required")
	@Size(max = 100 , message = "description letters bleow 100 ")
	private String description;
	
	@NotNull(message = "quantity must be required")
	private Integer quantity;
	
	@NotBlank(message = "unit must be required")
	@Size(max = 30 ,message  ="unit below 30 letters")
	private String unit;
	
	@NotNull(message =  "UnitPrice Must Be Required")
	private BigDecimal unitPrice;
	
	
	
}
