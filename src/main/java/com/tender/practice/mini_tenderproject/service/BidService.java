package com.tender.practice.mini_tenderproject.service;

import java.util.List;

import com.tender.practice.mini_tenderproject.dto.BidRequest;
import com.tender.practice.mini_tenderproject.dto.BidResponse;

public interface BidService {
	
	BidResponse bidCreation(BidRequest request);
	
	BidResponse getBidById(Long id);
	
	List<BidResponse> getAllBids();
	
//S	BidResponse updateBidById(Long id , BidRequest requset);

}
