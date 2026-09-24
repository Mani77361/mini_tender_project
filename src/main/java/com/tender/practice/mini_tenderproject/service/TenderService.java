package com.tender.practice.mini_tenderproject.service;

import java.math.BigDecimal;
import java.util.List;

import com.tender.practice.mini_tenderproject.TenderStatusProjection.TenderStatusProjection;
import com.tender.practice.mini_tenderproject.dto.TenderBidOrganizationReportResponse;
import com.tender.practice.mini_tenderproject.dto.TenderItemViewResponse;
import com.tender.practice.mini_tenderproject.dto.TenderOrganizationResponse;
import com.tender.practice.mini_tenderproject.dto.TenderRequest;
import com.tender.practice.mini_tenderproject.dto.TenderResponse;
import com.tender.practice.mini_tenderproject.dto.TenderStatusDetailsResponse;
import com.tender.practice.mini_tenderproject.dto.TenderStatusRequest;
import com.tender.practice.mini_tenderproject.dto.TenderStatusResponse;
import com.tender.practice.mini_tenderproject.entity.Tender;
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
	
	// it This Start With Or :::: FindBystatusopen or closed
	
	List<TenderStatusDetailsResponse> getTenderStatusOrStatus(List<String> statuses);
	
	List<TenderOrganizationResponse> getTenderOrganixzationDetails();
	
	TenderStatusResponse updateTenderStatus(long id, TenderStatusRequest request);
	
	List<TenderResponse> getTenderStatus(String status);
	
	List<TenderResponse> getTenderTitle(String status);
	
	List<TenderResponse> getTenderStatuses(List<String> statuses);
	
	TenderResponse updateTenderStatus(Long id,String status);
	
	List<TenderResponse> gettenderStatus(String status);
	
	//List<TenderResponse> getstatuses(List<String> statuses);

	List<TenderResponse> getstatuses(List<String> statuses);
	
	List<TenderBidOrganizationReportResponse> gettenderBidOrganizationreport(String status , BigDecimal estimatedValue);
	
	
	
	
}
