package com.tender.practice.mini_tenderproject.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenderItemBulkRequest {

	private List<Long> tenderItemId;
	
	private String description;
}
