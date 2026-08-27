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
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="tender_item")
public class TenderItem {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name ="tender_item_id")
	private Long tendrItemId;
	
	@Column(name = "tender_id")
	private Long tenderId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name ="quantity")
	private Integer quantity;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "unit_price", precision  = 12 ,scale = 2)
	private BigDecimal unitPrice;

}
