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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tender.practice.mini_tenderproject.dto.OrganizationRequest;
import com.tender.practice.mini_tenderproject.dto.OrganizationResponse;
import com.tender.practice.mini_tenderproject.serviceimpl.OrganizationServiceImpl;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class OrganizationController {
	
	@Autowired
	 
	 public OrganizationServiceImpl organizationServiceImpl;
	
	
	@PostMapping("/createorganization")
	public ResponseEntity<OrganizationResponse> createOrganization(@Valid @RequestBody OrganizationRequest request){
		
		OrganizationResponse response = organizationServiceImpl.createOrganization(request);
		
		return new ResponseEntity<>(response , HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrganizationResponse> getorganizationById(@Valid @PathVariable Long id){
		
		OrganizationResponse response  =  organizationServiceImpl.getOrganizationById(id);
		
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping
	public ResponseEntity<List<OrganizationResponse>> getAllOrganization(){
		
		List<OrganizationResponse> response = organizationServiceImpl.getAllOrganization();
		
		return ResponseEntity.ok(response);
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrganizationResponse> updateOrganization( @PathVariable Long id, @RequestBody OrganizationRequest request){
			
	    System.out.println("REQUEST OBJECT = " + request);
	    System.out.println("NAME = " + request.getOrganizationName());
	    System.out.println("DEPARTMENT = " + request.getDepartment());

		OrganizationResponse response =  organizationServiceImpl.updateOrganizationResponse(id, request);
		
		return ResponseEntity.ok(response);
		
	}	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrganizationById(@PathVariable Long id){
		
		organizationServiceImpl.deleteOrganizationById(id);
		
		return ResponseEntity.ok("Organization Deleted Successfully");
		
		
	}
	
}
