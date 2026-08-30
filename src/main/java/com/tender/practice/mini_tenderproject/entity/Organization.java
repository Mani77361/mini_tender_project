package com.tender.practice.mini_tenderproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organization")
public class Organization {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "organization_id")
	private Long organizationId;
	
	@Column(name = "organization_name")
	private String organizationName;
	
	@Column(name = "department")
	private String department;
	
}
