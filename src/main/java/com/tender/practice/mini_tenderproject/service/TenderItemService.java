package com.tender.practice.mini_tenderproject.service;

import java.util.List;

import com.tender.practice.mini_tenderproject.dto.TenderItemBulkRequest;
import com.tender.practice.mini_tenderproject.dto.TenderItemRequest;
import com.tender.practice.mini_tenderproject.dto.TenderItemResponse;

public interface TenderItemService {
	
	TenderItemResponse cerateTenderItem(TenderItemRequest request);
	
	TenderItemResponse findTenderItemById(long id);
	
	List<TenderItemResponse> findAllTenderItem();
	
	TenderItemResponse updateTenderItem(Long id, TenderItemRequest requerst);
	
	void updateBulkTenderItem(TenderItemBulkRequest request);
	
	void deleteById(Long id);
	
	
	
	

}
