package com.tender.practice.mini_tenderproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationRequest {

	@NotBlank(message = "Organization Name Must Be Required")
	@Size(max = 30 ,message = "Organization Name Must Be 30 letters below")
	private String organizationName;
	
	@NotBlank(message = "Department Must Be Required")
	@Size(max = 30 , message = "Department Must  be Below 30 words")
	private String department;
	
}
