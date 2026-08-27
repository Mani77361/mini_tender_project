	package com.tender.practice.mini_tenderproject.projection;
	
	import java.math.BigDecimal;
	import java.time.LocalDate;
	
	public interface TenderItemViewProjection {
		
		
		Long getTenderId();
		
		Long getTenderItemId();
		
		String getTenderName();
		
		LocalDate getPublishDate();
		
		Integer getQuantity();
		
		BigDecimal getPrice();
	
	}
