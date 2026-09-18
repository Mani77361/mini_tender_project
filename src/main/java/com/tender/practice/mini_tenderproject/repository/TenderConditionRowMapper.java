package com.tender.practice.mini_tenderproject.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tender.practice.mini_tenderproject.dto.TenderConditionResponse;

public class TenderConditionRowMapper implements RowMapper<TenderConditionResponse>{

	@Override
	public TenderConditionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		
		return new TenderConditionResponse(
				rs.getLong("tender_id"),
				rs.getString("tender_number"),
				rs.getString("title"),
				rs.getString("status"),
				rs.getBigDecimal("estimated_value"),
				rs.getString("organization_name"),
				rs.getString("department")
				);
	}
	

}
