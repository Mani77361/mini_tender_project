package com.tender.practice.mini_tenderproject.service;

import java.util.List;
import com.tender.practice.mini_tenderproject.repository.TenderRepository;
import org.springframework.stereotype.Service;
import com.tender.practice.mini_tenderproject.controller.TenderJdbcController;
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
	
	
	
	
}
