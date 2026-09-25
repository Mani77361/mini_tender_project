
package com.tender.practice.mini_tenderproject.repository;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.tender.practice.mini_tenderproject.dto.TenderOrganizationResponse1;
import com.tender.practice.mini_tenderproject.entity.Tender;
import com.tender.practice.mini_tenderproject.projection.TenderOrganizationProjection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class TenderCustomRepositoryImpl implements TenderCustomRepository {
	@PersistenceContext
	private final EntityManager entityManager;
	
	public TenderCustomRepositoryImpl(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Object[]> getAllTenders() {
		String sql = """
				select * from tender
				
				""";
		Query query=entityManager.createNativeQuery(sql);
		
		return query.getResultList();
	}

	@Override
	public List<Tender> getTendersByStatus(String status) {
		
		String sql = """
				
				select * 
				from tender 
				 where status = :status
				
				""";
		Query query = entityManager.createNativeQuery(sql,Tender.class);
		
		return query.setParameter("status", status)
				.getResultList();
		
		
		
	}

	@Override
	public List<Object[]> getTendersByEstimatedValue(BigDecimal estimatedValue) {
			
		String sql = """
				
				select 
					t.tender_number as tenderNumber,
					t.status as status,
					o.organization_name as organizationName,
					o.department as department
				from tender t 
				join organization o on t.organization_id = o.organization_id
						where estimated_value > :estimatedValue
				""";
		Query query = entityManager.createNativeQuery(sql);
		

		return query.setParameter("estimatedValue", estimatedValue)
				.getResultList();
	}
	
	
	
}