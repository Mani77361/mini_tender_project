package com.tender.practice.mini_tenderproject.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tender.practice.mini_tenderproject.dto.TenderOrganizationResponse;
import com.tender.practice.mini_tenderproject.dto.TenderOrganizationTenderItemDetailsResponse;
import com.tender.practice.mini_tenderproject.dto.TenderRequest;
import com.tender.practice.mini_tenderproject.dto.TenderResponse;
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



	@Override
	public List<TenderOrganizationResponse> findByTenderOrganizationDetails() {
		
		String sql = """
				select t.tender_number,
					t.title,
					t.status,
					o.organization_name,
					o.department
					FROM tender t JOIN organization o ON t.organization_id = o.organization_id
				""";
		
		return jdbcTemplate.query(sql,  
				new TenderOrganizationRowMapper()
				);
	}



	@Override
	public List<TenderOrganizationTenderItemDetailsResponse> findByTenderOrganizationTenderItemDetails() {
		
		String sql ="""
				select t.tender_number,
						t.title,
						t.status,
						o.organization_name,
						o.department,
						ti.item_name,
						ti.description,
						ti.quantity
						FROM tender t JOIN organization o ON t.organization_id = o.organization_id
					 	JOIN tender_item ti ON t.tender_id = ti.tender_id
			
				""";
		
		
		return jdbcTemplate.query(sql, 
				new TenderOrganizationTenderItemRowmapper());
	}
	
	@Override
	public Tender findById(Long id) {
		
		String sql = """
				select * from tender
				where tender_id= ?
				
				""";
		
		return jdbcTemplate.queryForObject(sql, 
										new TenderRowMapper(),
										id);
	}
	
	
	



	@Override
	public TenderResponse updateTender(Long id, TenderRequest request) {
		
		
		String sql ="""
				update tender
					set 
						title = ?,
						description = ?,
						status = ? 
					where
					 	tender_id =  ?
							""";
		
		int rows =  jdbcTemplate.update(
								sql,
									request.getTitle(),
									request.getDescription(),
									request.getStatus(),
									id
									);
		System.out.println("Rows updated = " + rows);
		
		//NO RECOrDS FOUND
		if(rows == 0) {
			
			throw new RuntimeException("no records not found" + id);
		}
		//get the updated tender
		
		Tender tend = findById(id);
		
		return new TenderResponse(
				tend.getId(),
				tend.getTenderNumber(),
				tend.getTitle(),
				tend.getDescription(),
				tend.getStatus(),
				tend.getOrganizationId(),
				tend.getPublishDate(),
				tend.getClosingDate(),
				tend.getEstimatedValue()
				);
		
	}



	@Override
	public TenderResponse findByTenderOrgganizatioDetailsWithCondition(Long organizationId, String status,
			BigDecimal estimatedValue) {
	
		String sql = """
					select 
						t.tender_id,
						t.tender_number,
						t.title,
						t.status,
						t.estimated_value,
						o.organization_name,
						o.department
						FROM tender t JOIN organization o ON t.organization_id = o.organization_id
						
						WHERE 
							organization_id =?,
							AND status = ?,
							AND estimated_value = ?							 
				
				
				""";
		
		
		return jdbcTemplate.query(sql, 
							new TenderConditionRowMapper(),
							organization_id,
							status ,
							estimated_value
							);
	}


	
	
	
	
	
	
	
	
	
}
