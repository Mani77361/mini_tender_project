package com.tender.practice.mini_tenderproject.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tender.practice.mini_tenderproject.dto.BidRequest;
import com.tender.practice.mini_tenderproject.dto.BidResponse;
import com.tender.practice.mini_tenderproject.entity.Bid;
import com.tender.practice.mini_tenderproject.repository.BidRepository;
import com.tender.practice.mini_tenderproject.service.BidService;

public class BidServiceImplementation implements BidService{

	@Autowired
	
	public BidRepository bidRepository;

	@Override
	public BidResponse bidCreation(BidRequest request) {
		Bid bid = new Bid();
		
		bid.setTenderId(request.getTenderId());
		bid.setSupplierId(request.getSupplierId());
		bid.setBidNumbre(request.getBidNumber());
		bid.setBidAmount(request.getBidAmount());
		bid.setStatus(request.getStatus());
		bid.setSubmittedDate(request.getSubmittedDate());
		
		Bid savedBid = bidRepository.save(bid);
		
		BidResponse response = new BidResponse();
		
		response.setTenderId(savedBid.getTenderId());
		response.setSupplierId(savedBid.getSupplierId());
		response.setBidAmount(savedBid.getBidAmount());
		response.setStatus(savedBid.getStatus());
		response.setSubmittedDate(savedBid.getSubmittedDate());
		
		
		return response;
	}

	@Override
	public BidResponse getBidById(Long id) {
		Bid bid = bidRepository.findById(id).orElseThrow(() -> new RuntimeException("Bid Id Not Found"));
		
		BidResponse response= new BidResponse();
		
		response.setTenderId(bid.getTenderId());
		response.setSupplierId(bid.getSupplierId());
		response.setBidNumber(bid.getBidNumbre());
		response.setBidAmount(bid.getBidAmount());
		response.setStatus(bid.getStatus());
		response.setSubmittedDate(bid.getSubmittedDate());
		
		return response;
	}

	@Override
	public List<BidResponse> getAllBids() {
		List<Bid> forr =bidRepository.findAll();
		
		List<BidResponse> responses = new ArrayList<>();
		
		for(Bid bids : forr) {
			BidResponse response = new BidResponse();
			
			response.setTenderId(bids.getTenderId());
			response.setSupplierId(bids.getSupplierId());
			response.setBidNumber(bids.getBidNumbre());
			response.setBidAmount(bids.getBidAmount());
			response.setStatus(bids.getStatus());
			response.setSubmittedDate(bids.getSubmittedDate());
			
			responses.add(response);
		}
		
		return responses;
	}

	
}
