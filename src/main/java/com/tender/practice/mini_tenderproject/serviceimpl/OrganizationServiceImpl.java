package com.tender.practice.mini_tenderproject.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tender.practice.mini_tenderproject.dto.OrganizationRequest;
import com.tender.practice.mini_tenderproject.dto.OrganizationResponse;
import com.tender.practice.mini_tenderproject.entity.Organization;
import com.tender.practice.mini_tenderproject.repository.OrganizationRepository;
import com.tender.practice.mini_tenderproject.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService{
	
	@Autowired
	public OrganizationRepository organizationRepository;
	
	

	@Override
	public OrganizationResponse createOrganization(OrganizationRequest request) {
		
		Organization org = new Organization();
		
		org.setOrganizationName(request.getOrganizationName());
		org.setDepartment(request.getDepartment());
		
		Organization savedOrganization = organizationRepository.save(org);
		
		OrganizationResponse response = new OrganizationResponse();
		
		response.setOrganizationId(savedOrganization.getOrganizationId());
		response.setOrganizationName(savedOrganization.getOrganizationName());
		response.setDepartment(savedOrganization.getDepartment());
		
		return response;
	}

	@Override
	public OrganizationResponse getOrganizationById(Long id) {
		Organization org = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Organization Not Found :"+ id));
		
		OrganizationResponse response = new OrganizationResponse();
		
		response.setOrganizationId(org.getOrganizationId());
		response.setOrganizationName(org.getOrganizationName());
		response.setDepartment(org.getDepartment());
		
		return response;
	}

	@Override
	public List<OrganizationResponse> getAllOrganization() {
		List<Organization> org = organizationRepository.findAll();
		
		List<OrganizationResponse> responses = new ArrayList<>();
		
		for(Organization response: org){
			
			OrganizationResponse og =  new OrganizationResponse();
			
			og.setOrganizationId(response.getOrganizationId());
			og.setOrganizationName(response.getOrganizationName());
			og.setDepartment(response.getDepartment());
			
			responses.add(og);
		}
		
		return responses;
	}

	@Override
	public OrganizationResponse updateOrganizationResponse(Long id, OrganizationRequest request) {
		Organization org = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException( "Organization ot Found :" + id));
		
		org.setOrganizationName(request.getOrganizationName());
		org.setDepartment(request.getDepartment());
		
		Organization savedOrganization = organizationRepository.save(org);
		
		OrganizationResponse  response =  new OrganizationResponse();
		
		response.setOrganizationId(savedOrganization.getOrganizationId());
		response.setOrganizationName(savedOrganization.getOrganizationName());
		response.setDepartment(savedOrganization.getDepartment());
		
		return response;
	}

	@Override
	public void deleteOrganizationById(Long id) {
		 
		Organization org  = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("organization Not Found :" + id));
		
		organizationRepository.delete(org);
		
	}
	
	

}
