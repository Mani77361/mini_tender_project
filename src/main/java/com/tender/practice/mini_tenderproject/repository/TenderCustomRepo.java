package com.tender.practice.mini_tenderproject.repository;

import java.util.List;

import com.tender.practice.mini_tenderproject.entity.Tender;

public interface TenderCustomRepo {
	
	List<Tender> findByStatus(String Status);
	
	List<Tender> findTenderByTitle(String title);
	
	List<Tender> findByStatuses(List<String> statuses );
	
	int updateTenderStatus(long id,String status);
	
	List<Tender> findStatus(String status);
	
	List<Tender> findStatuses(List<String> statuses);

}
