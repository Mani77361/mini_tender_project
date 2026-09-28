package com.tender.practice.mini_tenderproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TenderBidCountResponse {
	
	private Long id;
	
	private String tenderNumber;
	
	private String title;
	
	private String status;
	
	private Long bidCount;
}
