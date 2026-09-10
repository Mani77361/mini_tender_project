package com.tender.practice.mini_tenderproject.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tender.practice.mini_tenderproject.dto.BidItemRequest;
import com.tender.practice.mini_tenderproject.dto.BidItemResponse;
import com.tender.practice.mini_tenderproject.entity.BidItem;
import com.tender.practice.mini_tenderproject.repository.BidItemRepository;
import com.tender.practice.mini_tenderproject.service.BidItemService;

@Service
public class BidItemServiceImpl implements BidItemService{
	
	@Autowired
	public BidItemRepository bidItemRepository;

	@Override
	public BidItemResponse createBidItem(BidItemRequest request) {
		BidItem bitItem = new BidItem();
		
		bitItem.setBidId(request.getBidId());
		bitItem.setTenderItemId(request.getTenderItemId());
		bitItem.setQuantity(request.getQuantity());
		bitItem.setUnitPrice(request.getUnitPrice());
		bitItem.setTotalPrice(request.getTotalPrice());
		
		BidItem savedBidItem = bidItemRepository.save(bitItem);
		
		BidItemResponse response = new BidItemResponse();
		
		response.setBidItemId(savedBidItem.getBidItemId());
		response.setBidId(savedBidItem.getBidId());
		response.setTenderItemId(savedBidItem.getTenderItemId());
		response.setQuantity(savedBidItem.getQuantity());
		response.setUnitPrice(savedBidItem.getUnitPrice());
		response.setUnitPrice(savedBidItem.getUnitPrice());
		
		
		return response;
	}

	@Override
	public BidItemResponse bidItemGetById(Long id) {
		BidItem bitItem = bidItemRepository.findById(id).orElseThrow(() -> new RuntimeException("BidItemId Not Found :" + id));
		
		
		BidItemResponse bit = new BidItemResponse();
		
		bit.setBidItemId(bitItem.getBidItemId());
		bit.setBidId(bitItem.getBidId());
		bit.setTenderItemId(bitItem.getTenderItemId());
		bit.setQuantity(bitItem.getQuantity());
		bit.setUnitPrice(bitItem.getUnitPrice());
		bit.setTotalPrice(bitItem.getTotalPrice());
		
		return bit;
	}

	@Override
	public List<BidItemResponse> getAllBidItem() {
		List<BidItem> bid = bidItemRepository.findAll();
	
		List<BidItemResponse> responses = new ArrayList<>();
		
		for(BidItem Bids : bid) {
			
			BidItemResponse response =new BidItemResponse();
			
			response.setBidId(Bids.getBidId());
			response.setBidItemId(Bids.getBidItemId());
			response.setTenderItemId(Bids.getTenderItemId());
			response.setUnitPrice(Bids.getUnitPrice());
			response.setTotalPrice(Bids.getTotalPrice());
			
			responses.add(response);
		}
		
		return responses;
	}

	@Override
	public BidItemResponse updateBidItem(Long id, BidItemRequest request) {
		BidItem bid = bidItemRepository.findById(id).orElseThrow(() -> new RuntimeException("BidItem Id Not Found :" + id));
		
		
		bid.setBidId(request.getBidId());
		bid.setBidItemId(request.getBidId());
		bid.setTenderItemId(request.getTenderItemId());
		bid.setQuantity(bid.getQuantity());
		bid.setUnitPrice(request.getUnitPrice());
		bid.setTotalPrice(request.getTotalPrice());
		
		BidItem saved = bidItemRepository.save(bid);
		
		BidItemResponse response =new BidItemResponse();
		
		response.setBidId(saved.getBidId());
		response.setBidItemId(saved.getBidItemId());
		response.setTenderItemId(saved.getTenderItemId());
		response.setQuantity(saved.getQuantity());
		response.setUnitPrice(saved.getUnitPrice());
		response.setTotalPrice(saved.getTotalPrice());
		
		return response;
	}

	@Override
	public void deleteBidItemById(Long id) {
		
		BidItem bid= bidItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Bid Item Id Not Found :" + id));
		
		deleteBidItemById(id);
		
	}

}
