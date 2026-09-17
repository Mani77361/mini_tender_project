package com.tender.practice.mini_tenderproject.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tender.practice.mini_tenderproject.entity.Tender;

@Repository
public class TenderJdbcRepositoryImpl implements TenderJdbcRepository{

	private final JdbcTemplate jdbcTemplate;
	
	public TenderJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
		
	}
	
	
	
	public List<Tender> findByStatus(String status){
		
		String sql = """
				select * from tender 
				Where status = ?
				""";
		
		return jdbcTemplate.query(
				sql, 
				new TenderRowMapper() ,status
				);
		
	}


	@Override
	public List<Tender> findByTitle(String title) {
		
		String sql="""
				select * from 
				tender
				where title =?
				""";
		
		return jdbcTemplate.query(sql,  
				new TenderRowMapper(),
				title);
	}



	@Override
	public List<Tender> findByTenderNumber(String tenderNumber) {
		String sql = """
				select * from tender
				where title =?
				""";
		
		return jdbcTemplate.query(sql, 
				new TenderRowMapper(),
				tenderNumber);
	}



	@Override
	public int countTender() {
		String sql = """
				
				select count(*) 
				from tender
				""";
		return jdbcTemplate.queryForObject(
				sql,
				Integer.class);
	}



	@Override
	public List<Tender> findByTitleAndStatus(String title, String status) {
		
		String sql = """
				select * from 
				tender
				where title = ? 
				and status = ?
				""";
		
		
		return jdbcTemplate.query(sql, new TenderRowMapper(),title,status);
	}
	
	
	
	
	
}
