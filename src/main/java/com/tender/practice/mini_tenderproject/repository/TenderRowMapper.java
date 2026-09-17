package com.tender.practice.mini_tenderproject.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tender.practice.mini_tenderproject.entity.Tender;

public class TenderRowMapper implements RowMapper<Tender>{

	@Override
	public Tender mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tender tender = new Tender();
		
		tender.setId(rs.getLong("tender_id"));
		tender.setTitle(rs.getString("title"));
		tender.setDescription(rs.getString("description"));
		tender.setStatus(rs.getString("status"));
		tender.setTenderNumber(rs.getString("tender_number"));
		
		return tender;
	}
	
	

}
