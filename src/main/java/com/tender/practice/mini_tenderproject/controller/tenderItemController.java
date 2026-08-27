package com.tender.practice.mini_tenderproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tender.practice.mini_tenderproject.dto.TenderItemBulkRequest;
import com.tender.practice.mini_tenderproject.dto.TenderItemRequest;
import com.tender.practice.mini_tenderproject.dto.TenderItemResponse;
import com.tender.practice.mini_tenderproject.serviceimpl.TenderItemServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

/**
 * 
 */
@RestController
@RequestMapping("/api/tenderitem")
public class tenderItemController {
	@Autowired
	public  TenderItemServiceImpl tenderItemServiceImpl;
	@PostMapping
	public ResponseEntity<TenderItemResponse> createTenderItem(@Valid @RequestBody TenderItemRequest request){
		
		TenderItemResponse tender = tenderItemServiceImpl.cerateTenderItem(request);
		
		return new ResponseEntity<>(tender , HttpStatus.CREATED);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<TenderItemResponse> findTenderItemById(@Valid @PathVariable Long id){
		
		TenderItemResponse response = tenderItemServiceImpl.findTenderItemById(id);
		
		return ResponseEntity.ok(response);
		
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<TenderItemResponse>> findAllTenderItem(){
		
		List<TenderItemResponse> tenders = tenderItemServiceImpl.findAllTenderItem();
		
		return ResponseEntity.ok(tenders);
		
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<TenderItemResponse> updateTenderItem(@PathVariable Long id, @RequestBody TenderItemRequest request){
		
		TenderItemResponse response  = tenderItemServiceImpl.updateTenderItem(id, request);
		
		return ResponseEntity.ok(response);
		
	}
	
	
	@PutMapping("/request")
	public ResponseEntity<String> updateBulkItemId(@Valid @RequestBody TenderItemBulkRequest request){
		
		tenderItemServiceImpl.updateBulkTenderItem(request);
		
		return ResponseEntity.ok("Description Updated SUccessfully");
	}
	@DeleteMapping(".{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long Id){
	
		tenderItemServiceImpl.deleteById(Id);
		
		return ResponseEntity.ok("tender Item Id Deleted SuccessFully");
}
	
	

}
