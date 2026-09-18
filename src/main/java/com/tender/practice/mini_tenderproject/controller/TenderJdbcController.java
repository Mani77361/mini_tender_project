package com.tender.practice.mini_tenderproject.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tender.practice.mini_tenderproject.dto.TenderBidResponse;
import com.tender.practice.mini_tenderproject.dto.TenderConditionResponse;
import com.tender.practice.mini_tenderproject.dto.TenderOrganizationResponse;
import com.tender.practice.mini_tenderproject.dto.TenderOrganizationTenderItemDetailsResponse;
import com.tender.practice.mini_tenderproject.dto.TenderRequest;
import com.tender.practice.mini_tenderproject.dto.TenderResponse;
import com.tender.practice.mini_tenderproject.entity.Tender;
import com.tender.practice.mini_tenderproject.service.TenderJdbcService;

@RestController
@RequestMapping("/api/jdbc")

public class TenderJdbcController {


	private final TenderJdbcService tenderJdbcService;
	
	public TenderJdbcController(TenderJdbcService tenderJdbcService) {
		this.tenderJdbcService = tenderJdbcService;
		
	}
	
	@GetMapping("/status")
	public ResponseEntity<List<Tender>> findByStatus(@RequestParam String status){
		return ResponseEntity.ok(tenderJdbcService.findByStatus(status));
		
		
		
	}
	@GetMapping("/title")
	public ResponseEntity<List<Tender>> findByTitle(@RequestParam String title){
		return ResponseEntity.ok(tenderJdbcService.findByTitle(title));
	}
	
	@GetMapping("/tenderNumber/{tenderNumber}")
	public ResponseEntity<List<Tender>> findByTenderNumber( @PathVariable("tenderNumber") String tenderNumber){
		return ResponseEntity.ok(tenderJdbcService.findByTenderNumber(tenderNumber));
		
	}
	@GetMapping("/count")
	public ResponseEntity<Integer> countTender(){
		return  ResponseEntity.ok(tenderJdbcService.countTender());
		
	}		
	@GetMapping("/titleandstatus/{title}/{status}")
	public ResponseEntity<List<Tender>> findTenderAndStatus(@PathVariable("title") String title,@PathVariable("status") String status){
		
		return ResponseEntity.ok(tenderJdbcService.findByTendeTitelAndStatus(title, status));
		
		
	}
	@GetMapping("/details")
	public ResponseEntity<List<TenderOrganizationResponse>> findTederOrganizationDetails(){
		
		return ResponseEntity.ok(tenderJdbcService.findTenderOrganizationDetails());
		
		
	}
	@GetMapping("/detailss/de")
	public ResponseEntity<List<TenderOrganizationTenderItemDetailsResponse>> findTenderOrganizationTenderItem(){
		
		return ResponseEntity.ok(tenderJdbcService.findByTenderOrganizationTenderItemResponse());
		
	}
	 @PutMapping("update/up/{id}")
	public ResponseEntity< TenderResponse> updateTender(@PathVariable Long id , @RequestBody TenderRequest request){
		 
		 return ResponseEntity.ok(tenderJdbcService.updateTender(id, request));
		 
	 }
	 
	 @GetMapping("/getdetails")
	 public ResponseEntity<List<TenderConditionResponse>> getTenderOrganizationDetails(@RequestParam Long organizationId, @RequestParam String status ,@RequestParam BigDecimal estimatedValue){
		 
		 return ResponseEntity.ok(tenderJdbcService.getTenderOrganizationDetailsWithCondition(organizationId, status, estimatedValue));
		 
	 }
	
	
	 
	@GetMapping("/search")
	 public ResponseEntity<List<TenderOrganizationTenderItemDetailsResponse>> getTenderOrganizationTenderItemDetaails(@RequestParam(value = "status", required = false) String status,
			 																					@RequestParam(value = "organization_id", required = false) Long OrganizationId,
	 																							@RequestParam(value = "estimated_value",  required = false) Integer minValue,
	 																							@RequestParam(value = "estimated_value", required = false) Integer maxValue,
	 																							@RequestParam(value = "title", required = false) String title){
		List<TenderOrganizationTenderItemDetailsResponse> result = tenderJdbcService.getTenderOrganizationTenderItemDetails(status, OrganizationId, minValue, maxValue, title);
	 	
	 				return ResponseEntity.ok(result);												
	 																								
	 																							
	 			}
	@GetMapping("/biddetails/{status}/{title}")
	public ResponseEntity<List<TenderBidResponse>> getTenderBidDetails(@PathVariable String status,@PathVariable String title){
		return ResponseEntity.ok(tenderJdbcService.getTenderBidDetails(status,title));
		
		
	}
	 
	 
	
	
}
