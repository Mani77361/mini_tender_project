package com.tender.practice.mini_tenderproject.repository;

import java.math.BigDecimal;
import java.util.List;

import com.tender.practice.mini_tenderproject.dto.TenderOrganizationResponse;
import com.tender.practice.mini_tenderproject.dto.TenderOrganizationTenderItemDetailsResponse;
import com.tender.practice.mini_tenderproject.dto.TenderRequest;
import com.tender.practice.mini_tenderproject.dto.TenderResponse;
import com.tender.practice.mini_tenderproject.entity.Tender;

public interface TenderJdbcRepository {
	
	 List<Tender> findByStatus(String status);
	 
	 List<Tender> findByTitle(String title);
	 
	 List<Tender> findByTenderNumber(String TenderNumber);
	 
	int countTender();
	List<Tender> findByTitleAndStatus(String title ,String status);

	List<TenderOrganizationResponse> findByTenderOrganizationDetails();
	
	List<TenderOrganizationTenderItemDetailsResponse> findByTenderOrganizationTenderItemDetails();
	
	Tender findById(Long id);
	
	TenderResponse updateTender(Long id,TenderRequest request);
	
	TenderResponse findByTenderOrgganizatioDetailsWithCondition(Long organizationId,String status,BigDecimal estimatedValue);
	
	
	
}
