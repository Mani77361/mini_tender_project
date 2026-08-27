package com.tender.practice.mini_tenderproject.service;

import java.util.List;

import com.tender.practice.mini_tenderproject.dto.TenderItemViewResponse;
import com.tender.practice.mini_tenderproject.dto.TenderRequest;
import com.tender.practice.mini_tenderproject.dto.TenderResponse;
import com.tender.practice.mini_tenderproject.projection.TenderItemViewProjection;

public interface TenderService {
	
	TenderResponse createTender(TenderRequest request);
	
	TenderResponse getTenderById(Long id);
	
	List<TenderResponse> getAllTenders();
	
	TenderResponse updateTenderResponse(Long id , TenderRequest request);

	void deleteTenderById(Long id);
	
	List<TenderResponse> getTenderByStatus(String status);
	
	List<TenderResponse> findTenderByTitle(String title);
	
	List<TenderResponse> findTenderByTitleAndStatus(String title, String status);
	
	List<TenderResponse> searchTenderByClosingWithInDays(int days);
	
//	List<TenderResponse> getTenderByOrganizationId(Long id);
	
	TenderResponse submitTender(Long id);
	
	List<TenderItemViewResponse> getTenderItemDtails();
	
	
	
	
	
}
