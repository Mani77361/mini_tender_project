package com.tender.practice.mini_tenderproject.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tender")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tender {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tender_id")
	private Long id;
	
	@Column(name ="tender_number")
	private String tenderNumber;
	
	@Column(name ="title")
	private String title;
	
	@Column(name ="description")
	private String description;
	
	@Column(name = "status")
	private String status;
	
	@Column(name ="organization_id")
	private Long organizationId;
	
	@Column(name = "published_date")
	private LocalDate publishDate;
	
	@Column(name ="closing_date")
	private LocalDate closingDate;
	
	@Column(name ="estimated_value")
	private BigDecimal estimatedValue;
	
}
