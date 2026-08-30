package com.tender.practice.mini_tenderproject.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BidRequest {

	@NotNull(message = "tenderId must Be Required")
	private Long tenderId;
	
	@NotNull(message = "supplierId Must Be Required")
	private Long supplierId;
	
	@NotBlank(message = "bidNumber Must Be Required")
	private String bidNumber;
	
	@NotNull(message = "bidAmount Must Be Required")
	private BigDecimal bidAmount;
	
	@NotBlank(message = "status Must Be Required")
	private String status;
	
	@NotBlank(message =  "Date Must Be Required")
	private LocalDate submittedDate;
}
