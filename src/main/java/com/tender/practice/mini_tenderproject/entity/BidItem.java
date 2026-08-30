package com.tender.practice.mini_tenderproject.entity;

import java.math.BigDecimal;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bid_item")
public class BidItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid_item_id")
	private Long bidItemId;
	
	@Column(name ="bid_id")
	private Long bidId;
	
	@Column(name = "tender_item_id")
	private Long tenderItemId;
	
	@Column(name ="unit_price")
	private BigDecimal unitPrice;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "total_price")
	private BigDecimal totalPrice;
	
}
