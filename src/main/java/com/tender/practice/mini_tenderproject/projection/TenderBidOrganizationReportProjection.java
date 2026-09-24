package com.tender.practice.mini_tenderproject.projection;

import java.math.BigDecimal;

public interface TenderBidOrganizationReportProjection {

	    String getTenderNumber();

	    String getTitle();

	    String getStatus();

	    BigDecimal getEstimatedValue();

	    String getOrganizationName();

	    String getDepartment();

	    Long getTotalItem();

	    Long getTotalBid();

	    BigDecimal getLowestBidAmount();

	    BigDecimal getHighestBidAmount();
	}

