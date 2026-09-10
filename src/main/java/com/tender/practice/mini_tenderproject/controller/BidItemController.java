package com.tender.practice.mini_tenderproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tender.practice.mini_tenderproject.dto.BidItemRequest;
import com.tender.practice.mini_tenderproject.dto.BidItemResponse;
import com.tender.practice.mini_tenderproject.serviceimpl.BidItemServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/biditem")
public class BidItemController {

	private final BidItemServiceImpl bidItemServiceImpl;
	
	public BidItemController(BidItemServiceImpl bidItemServiceImpl) {
		
		this.bidItemServiceImpl = bidItemServiceImpl;
	}
	
	@PostMapping("/create")
	public ResponseEntity<BidItemResponse> createBidItem(@RequestBody BidItemRequest request){
		
	BidItemResponse bid =   bidItemServiceImpl.createBidItem(request);
		
		return new ResponseEntity<>(bid, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BidItemResponse> getBidItemById(@PathVariable Long id){
		
		BidItemResponse bid = bidItemServiceImpl.bidItemGetById(id);
		
		return ResponseEntity.ok(bid);
		
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<BidItemResponse>> getAllBidItem(){
		
		List<BidItemResponse> bid = bidItemServiceImpl.getAllBidItem();
		
		return ResponseEntity.ok(bid);
		
		
	}
	
	@PutMapping("/update/{id}x")
	public ResponseEntity<BidItemResponse> updateBidItem(@PathVariable Long id,@RequestBody BidItemRequest request){
		
		BidItemResponse bid = bidItemServiceImpl.updateBidItem(id, request);
		
		return ResponseEntity.ok(bid);
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBidItemById(@PathVariable Long id){
		
	bidItemServiceImpl.deleteBidItemById(id);
		
		 return ResponseEntity.noContent().build();
		
		
	}
	
	
	
	
	

}
