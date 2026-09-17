package com.tender.practice.mini_tenderproject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tender.practice.mini_tenderproject.dto.TenderTitleAndstatusResponse;
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
	
	
	
}
