package com.tender.practice.mini_tenderproject.repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tender.practice.mini_tenderproject.dto.TenderBidResponse;

public class TenderBidRowMapper implements RowMapper<TenderBidResponse> {

	@Override
	public TenderBidResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new TenderBidResponse(
								rs.getString("tender_number"),
								rs.getString("title"),
								rs.getString("status"),
								rs.getBigDecimal("estimated_value"),
								rs.getString("organization_name"),
								rs.getString("department"),
								rs.getLong("totalItems"),
								rs.getLong("totalBids"),
								rs.getBigDecimal("lowestBidAmount"),
								rs.getBigDecimal("highestBidAmount")

									);
	}

}
