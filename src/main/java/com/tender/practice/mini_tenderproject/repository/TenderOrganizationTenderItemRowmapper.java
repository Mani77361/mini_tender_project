package com.tender.practice.mini_tenderproject.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tender.practice.mini_tenderproject.dto.TenderOrganizationTenderItemDetailsResponse;

public class TenderOrganizationTenderItemRowmapper implements RowMapper<TenderOrganizationTenderItemDetailsResponse>{

	@Override
	public TenderOrganizationTenderItemDetailsResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	

		return new TenderOrganizationTenderItemDetailsResponse(
				rs.getString("tender_number"),
				rs.getString("title"),
				rs.getString("status"),
				rs.getString("organization_name"),
				rs.getString("department"),
				rs.getString("item_name"),
				rs.getString("description"),
				rs.getInt("quantity")
				);
	
	}

	

}
