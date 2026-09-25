package com.tender.practice.mini_tenderproject.repository;

import java.math.BigDecimal;
import java.util.List;

import com.tender.practice.mini_tenderproject.dto.TenderOrganizationResponse1;
import com.tender.practice.mini_tenderproject.entity.Tender;
import com.tender.practice.mini_tenderproject.projection.TenderOrganizationProjection;

public interface TenderCustomRepository {
	
	List<Object[]> getAllTenders();
	
	
	List<Tender> getTendersByStatus(String status);
	
	List<Object[]> getTendersByEstimatedValue(BigDecimal estimatedValue);
	

}
