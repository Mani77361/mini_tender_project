package com.tender.practice.mini_tenderproject.TenderStatusProjection;

import java.math.BigDecimal;

public interface TenderStatusProjection {
	
	Long getTenderId();
	
	String getTitle();
	
	String getDescribtion();
	
	String getStatus();
	
	Long getTenderItemId();
	
	Integer getQuantity();
	
	String getUnit();
	
	BigDecimal getPrice();
	
	
	
	

	
	
	
	

}
