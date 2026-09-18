package com.tender.practice.mini_tenderproject.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

import com.tender.practice.mini_tenderproject.dto.TenderBidResponse;
import com.tender.practice.mini_tenderproject.dto.TenderConditionResponse;
import com.tender.practice.mini_tenderproject.dto.TenderOrganizationResponse;
import com.tender.practice.mini_tenderproject.dto.TenderOrganizationTenderItemDetailsResponse;
import com.tender.practice.mini_tenderproject.dto.TenderRequest;
import com.tender.practice.mini_tenderproject.dto.TenderResponse;
import com.tender.practice.mini_tenderproject.entity.Tender;
import com.tender.practice.mini_tenderproject.repository.TenderJdbcRepository;

@Service
public class TenderJdbcService {

   
	private final TenderJdbcRepository tenderJdbcRepository;
	
	public TenderJdbcService(TenderJdbcRepository tenderJdbcRepository) {
		
		this.tenderJdbcRepository = tenderJdbcRepository;
		
		
	}
	
	public List<Tender> findByStatus(String status){
		return tenderJdbcRepository.findByStatus(status);
		
	}
	
	public List<Tender> findByTitle(String title){
		return tenderJdbcRepository.findByTitle(title);
	}
	
	public List<Tender> findByTenderNumber(String tenderNumber){
		return tenderJdbcRepository.findByTenderNumber(tenderNumber);
	}
	public int countTender() {
		
		return tenderJdbcRepository.countTender();
	}
	
	public List<Tender> findByTendeTitelAndStatus(String title,String status){
		
		return tenderJdbcRepository.findByTitleAndStatus(title, status);
		
	}
	
	public List<TenderOrganizationResponse> findTenderOrganizationDetails(){
		
		
		return tenderJdbcRepository.findByTenderOrganizationDetails();
	}
	
	public List<TenderOrganizationTenderItemDetailsResponse> findByTenderOrganizationTenderItemResponse(){
		return tenderJdbcRepository.findByTenderOrganizationTenderItemDetails();
		
	}
	
	public TenderResponse updateTender(Long id,TenderRequest request) {
		
		return tenderJdbcRepository.updateTender(id, request);
	}
	
	public List<TenderConditionResponse> getTenderOrganizationDetailsWithCondition(Long organizationId, String status , BigDecimal estimatedvalue){
		
		return tenderJdbcRepository.findByTenderOrgganizatioDetailsWithCondition(organizationId, status, estimatedvalue);
		
		
	}
	public List<TenderOrganizationTenderItemDetailsResponse> getTenderOrganizationTenderItemDetails(String status,Long organizationId , Integer minValue , Integer maxValue, String title ){
		
		  System.out.println("status = " + status);
		    System.out.println("organizationId = " + organizationId);
		    System.out.println("minValue = " + minValue);
		    System.out.println("maxValue = " + maxValue);
		    System.out.println("title = " + title);
		    
		return tenderJdbcRepository.findBytenderOrganizationTenderItemDeatails(status, organizationId, minValue, maxValue, title);
		
		
	}
	public List<TenderBidResponse> getTenderBidDetails(String status,String title){
		
		return tenderJdbcRepository.findTenderBid(status,title);
		
		
	}
	
	
}
