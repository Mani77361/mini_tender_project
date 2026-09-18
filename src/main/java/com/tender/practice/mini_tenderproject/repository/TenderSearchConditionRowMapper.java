package com.tender.practice.mini_tenderproject.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tender.practice.mini_tenderproject.dto.TenderOrganizationTenderItemDetailsResponse;

public class TenderSearchConditionRowMapper implements RowMapper<TenderOrganizationTenderItemDetailsResponse> {

	@Override
	public TenderOrganizationTenderItemDetailsResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new TenderOrganizationTenderItemDetailsResponse (
				rs.getLong("tender_id"),
				rs.getString("tender_number"),
				rs.getString("title"),
				rs.getString("status"),
				rs.getBigDecimal("estimated_value"),
				rs.getString("organization_name"),
				rs.getString("department"),
				rs.getString("item_name"),
				rs.getInt("quantity")

				);
	}

}
