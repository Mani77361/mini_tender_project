package com.tender.practice.mini_tenderproject.service;

import java.util.List;
import com.tender.practice.mini_tenderproject.repository.TenderRepository;
import org.springframework.stereotype.Service;

import com.tender.practice.mini_tenderproject.entity.Tender;
import com.tender.practice.mini_tenderproject.repository.TenderJdbcRepository;

@Service
public class TenderJdbcService {

    private final TenderRepository tenderRepository;

	private final TenderJdbcRepository tenderJdbcRepository;
	
	public TenderJdbcService(TenderJdbcRepository tenderJdbcRepository, TenderRepository tenderRepository) {
		
		this.tenderJdbcRepository = tenderJdbcRepository;
		
		this.tenderRepository = tenderRepository;
		
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
	
	
	
}
