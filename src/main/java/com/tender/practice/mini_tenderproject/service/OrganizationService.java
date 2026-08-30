package com.tender.practice.mini_tenderproject.service;

import java.util.List;

import com.tender.practice.mini_tenderproject.dto.OrganizationRequest;
import com.tender.practice.mini_tenderproject.dto.OrganizationResponse;

public interface OrganizationService {
	
	OrganizationResponse createOrganization(OrganizationRequest request);
	
	OrganizationResponse getOrganizationById(Long id);
	
	List<OrganizationResponse> getAllOrganization();
	
	OrganizationResponse updateOrganizationResponse(Long id, OrganizationRequest request);
	
	void deleteOrganizationById(Long id);
	

}
