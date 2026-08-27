package com.tender.practice.mini_tenderproject.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class TenderRequest {
	
	@NotNull(message ="Tender Number Is Required")
	@Size(max=50 ,message = "Tender Numbre Must Not Exceed 50 Charecter")
	private String tenderNumber;
	
	@NotBlank(message = "Tender Titl Must Be Required")
	@Size(max = 30, message = "Title Charecter Must Be Below 30")
	private String title;
	
	@NotBlank(message = "Description Is Required")
	@Size(max = 1000, message = "Description Must Be Below 1000 Charecter")
	private String description;
	
	@NotBlank(message = "Status Is Required")
	@Size(max = 20, message = "Size Must Be Below 20 Charecter")
	private String status;
	
	@NotNull(message = "Orgagnization Id is Required")
	private Long organizationId;
	
	@NotNull(message  = "Publis Date Must be Important")
	private LocalDate publishDate;
	
	@NotNull(message = "Closing Date Is Required")
	@Future(message = "Closing Date Must Be in Future Date" )
	private LocalDate closingDate;
	
	@NotNull(message = "Estimated Value Is Required")
	@Positive(message = "EstimatedValueMustBePossitiva")
	private BigDecimal estimatedValue;
}
