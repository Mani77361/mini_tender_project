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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bid")
public class Bid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid_id")
	private Long bidId;
	
	@Column(name ="tender_id")
	private Long tenderId;
	
	@Column(name ="supplier_id")
	private Long supplierId;
	
	@Column(name = "bid_number")
	private String bidNumbre;
	
	@Column(name = "bid_amount")
	private BigDecimal bidAmount;
	
	@Column(name ="status")
	private String status;
	
	@Column(name ="subbmited_date")
	private LocalDate submittedDate;

}
