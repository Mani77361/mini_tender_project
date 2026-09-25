package com.tender.practice.mini_tenderproject.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tender.practice.mini_tenderproject.dto.TenderBidOrganizationReportResponse;
import com.tender.practice.mini_tenderproject.dto.TenderItemViewResponse;
import com.tender.practice.mini_tenderproject.dto.TenderOrganizationResponse;
import com.tender.practice.mini_tenderproject.dto.TenderOrganizationResponse1;
import com.tender.practice.mini_tenderproject.dto.TenderRequest;
import com.tender.practice.mini_tenderproject.dto.TenderResponse;
import com.tender.practice.mini_tenderproject.dto.TenderStatusDetailsResponse;
import com.tender.practice.mini_tenderproject.dto.TenderStatusRequest;
import com.tender.practice.mini_tenderproject.dto.TenderStatusResponse;
import com.tender.practice.mini_tenderproject.projection.TenderBidOrganizationReportProjection;
import com.tender.practice.mini_tenderproject.repository.TenderRepository;
import com.tender.practice.mini_tenderproject.serviceimpl.TenderServiceimpl;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tender")
public class TenderController {

    private final TenderServiceimpl tenderServiceImpl;
	
	public TenderController(TenderServiceimpl tenderServiceimpl) {
		
		this.tenderServiceImpl = tenderServiceimpl;
		
		
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<TenderResponse> createTender(@Valid @RequestBody TenderRequest request){
		System.out.println("REQUEST OBJECT = " + request);
		TenderResponse tender = tenderServiceImpl.createTender(request);
		
		return new ResponseEntity<>(tender ,HttpStatus.CREATED);
	}
	@PostMapping("{id}")
	public ResponseEntity<TenderResponse> getTenderById(@PathVariable Long id) {
		
		TenderResponse tender =tenderServiceImpl.getTenderById(id);
		
		return ResponseEntity.ok(tender);
		
	}
	
//	
//	@GetMapping
//	public ResponseEntity<List<TenderResponse>>  getAllTenders(){
//		
//		List<TenderResponse> tenders =tenderServiceImpl.getAllTenders();
//		
//		return ResponseEntity.ok(tenders);
//	}	
//	
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<TenderResponse> updateTender(@PathVariable long id,@RequestBody TenderRequest request){
		TenderResponse response = tenderServiceImpl.updateTenderResponse(id, request);
		
		return ResponseEntity.ok(response);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteTenderById(@PathVariable Long id) {
		
		tenderServiceImpl.deleteTenderById(id);
		
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/status/{status}")
	public ResponseEntity<List<TenderResponse>> getTenderByStatus(@PathVariable String status){
		
		List<TenderResponse> response = tenderServiceImpl.getTenderByStatus(status);
		
		return  ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<List<TenderResponse>> searchTenderByTitle(@PathVariable String title){
		
		List<TenderResponse> response = tenderServiceImpl.findTenderByTitle(title);
		
		return ResponseEntity.ok(response);
			
		
	}
	@GetMapping("/titleandstatus/{title}/{status}")
	public ResponseEntity<List<TenderResponse>> findTenderByTitleAndStatus(@PathVariable String title,@PathVariable String status ){
		List<TenderResponse> response = tenderServiceImpl.findTenderByTitleAndStatus(title, status);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/days/{days}")
	public ResponseEntity<List<TenderResponse>> searchTenderByClosingWithInDays(@PathVariable int days){
		List<TenderResponse> tender = tenderServiceImpl.searchTenderByClosingWithInDays(days);	
		
		return ResponseEntity.ok(tender);
	}
	/*
	 * @GetMapping("/organizationId/{organization_id}") public
	 * ResponseEntity<List<TenderResponse>> getTenderByOrganizationId(@PathVariable
	 * Long id){
	 * 
	 * List<TenderResponse> tender =tenderServiceImpl.getTenderByOrganizationId(id);
	 * 
	 * return ResponseEntity.ok(tender);
	 * 
	 * 
	 * }
	 */
	
	
	@PostMapping("/tenderstatus/{id}")
	public ResponseEntity<TenderResponse> submitTender(@PathVariable Long id ){
		
		TenderResponse response =  tenderServiceImpl.submitTender(id);
		
		return ResponseEntity.ok(response);
		
		
	}
	@GetMapping("/response")
	public ResponseEntity<List<TenderItemViewResponse>> getTenderItemDeatils(){
		
		List<TenderItemViewResponse> response = tenderServiceImpl.getTenderItemDtails();
		
		return ResponseEntity.ok(response);
		
		
		
	}
	@GetMapping("/status")
	public ResponseEntity<List<TenderStatusDetailsResponse>> gteTenderStatusDetails(@RequestParam List<String> statuses ){
		
		return ResponseEntity.ok(tenderServiceImpl.getTenderStatusOrStatus(statuses));
		
	}
	@GetMapping("/details")
	public ResponseEntity<List<TenderOrganizationResponse>> getTenderOrganizationDetails(){
		
		List<TenderOrganizationResponse> response = tenderServiceImpl.getTenderOrganixzationDetails();
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	@PutMapping("/updatestatus/{id}")
	public ResponseEntity<TenderStatusResponse> updateTenderStatus(@PathVariable Long id,@RequestBody TenderStatusRequest request){
		
		TenderStatusResponse response = tenderServiceImpl.updateTenderStatus(id, request);
		
		return new ResponseEntity<>(response ,HttpStatus.OK);
		
		
	}
	@GetMapping("/statusby/{status}")
	public ResponseEntity<List<TenderResponse>> getTenderStatus(@PathVariable String status){
		
		List<TenderResponse> response = tenderServiceImpl.getTenderStatus(status);
		
		return new ResponseEntity<>(response ,HttpStatus.OK);
		
	}
	@GetMapping("/titleby/{title}")
	public ResponseEntity<List<TenderResponse>> findByTitle(@PathVariable String title){
		
		List<TenderResponse> response = tenderServiceImpl.findTenderByTitle(title);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
		
	}
	@GetMapping("/statuses/status")
	public ResponseEntity<List<TenderResponse>> findByStatuses(@RequestParam  List<String> statuses){
		
		List<TenderResponse> response = tenderServiceImpl.getTenderStatuses(statuses);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@PutMapping("/updateby/{id}")
	public ResponseEntity<TenderStatusResponse> updateTenderStatus(@PathVariable long id,@RequestBody TenderStatusRequest request){
		TenderStatusResponse response =tenderServiceImpl.updateTenderStatus(id, request);
		
		return ResponseEntity.ok(response);
		
		
	}
	
	@GetMapping("/sta/status")
	public ResponseEntity<List<TenderResponse>> getstatuses(@RequestParam List<String> statuses){
		
		List<TenderResponse> response = tenderServiceImpl.getstatuses(statuses);
		
		return ResponseEntity.ok(response);
		
		
	}
	@GetMapping("/reports")
	public ResponseEntity<List<TenderBidOrganizationReportResponse>> getTenderBidOrganizationReport(@RequestParam String status,
																										@RequestParam BigDecimal estimatedValue){
		
		return ResponseEntity.ok(tenderServiceImpl.gettenderBidOrganizationreport(status, estimatedValue));
		
		
		
	}
	
	@GetMapping("/getAllTenders")
	public ResponseEntity<List<Object[]>> getAllTender(){
		
		return ResponseEntity.ok(tenderServiceImpl.getAllTenders());
		
	}
	
	@GetMapping("/get/status/{status}")
	public ResponseEntity<List<TenderResponse>> getTenderByStatusS(@PathVariable String status){
		
		return ResponseEntity.ok(tenderServiceImpl.getTenderByStatus(status));
		
	}
	
	@GetMapping("/estimated/{estimatedValue}")
	public ResponseEntity<List<TenderOrganizationResponse1>> getTenderByEstimatedValue(@PathVariable BigDecimal estimatedValue){
		
		return ResponseEntity.ok(tenderServiceImpl.getTenderByEstimatedValue(estimatedValue));
		
		
	}
	
	
	
	
	
}

