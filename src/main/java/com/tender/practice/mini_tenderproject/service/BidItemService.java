package com.tender.practice.mini_tenderproject.service;

import java.util.List;

import com.tender.practice.mini_tenderproject.dto.BidItemRequest;
import com.tender.practice.mini_tenderproject.dto.BidItemResponse;

public interface BidItemService {
	
	BidItemResponse createBidItem(BidItemRequest request);
	
	
	BidItemResponse bidItemGetById(Long id);
	
	List<BidItemResponse> getAllBidItem();
	
	
	BidItemResponse updateBidItem(Long id,BidItemRequest request);
	
	void deleteBidItemById(Long id);
	
	
	
	
	
	

}
