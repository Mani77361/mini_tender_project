package com.tender.practice.mini_tenderproject.repository;

import java.util.List;

import com.tender.practice.mini_tenderproject.entity.Tender;

public interface TenderJdbcRepository {
	
	 List<Tender> findByStatus(String status);
	 
	 List<Tender> findByTitle(String title);
	 
	 List<Tender> findByTenderNumber(String TenderNumber);
	 
	int countTender();
	List<Tender> findByTitleAndStatus(String title ,String status);

}
