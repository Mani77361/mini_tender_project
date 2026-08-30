package com.tender.practice.mini_tenderproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tender.practice.mini_tenderproject.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	
	

}
