
package com.tender.practice.mini_tenderproject.repository;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.tender.practice.mini_tenderproject.entity.Tender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;

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

	@Override
	public List<Object[]> findTenderByOrganization(String organizationName) {
	
		String sql = """
				
				select 
					t.tender_number as tenderNumber,
					t.title as title,
					t.status as status,
					o.organization_name as organizationName,
					o.department as department
					from tender t 
						join organization o on t.organization_id =o.organization_id
						 	where organization_name = :organizationName
				
				""";
		
		Query query = entityManager.createNativeQuery(sql);
		
		
		return query.setParameter("organizationName", organizationName)
				.getResultList();
	}

	@Override
	public List<Object[]> findTenderItemCount() {

//****---	join -only matching records if tender has 0 items it not appear the tender
//		but LEFT JOIN is this all tender with and without items appearthe output so this this the various---------*******,
//      group by ---tender_id using for uniqe number of all tender ,so tender id has how many tender_item have  
		String sql = """
		 		select 
		 			t.tender_id as id,	
		 			t.tender_number as tenderNumber,
		 			t.title as title,
		 			t.status as status,
		 			count(ti.tender_item_id) as tenderItem
		 			
		 			from tender t 
		 				left join tender_item ti on t.tender_id = ti.tender_id 
		 				
		 				group by 
		 					t.tender_id,
		 					t.tender_number,
		 					t.title,
		 					t.status	
		 				
		 		
		 		""";
		 
		 Query query =  entityManager.createNativeQuery(sql);
		return query.getResultList();
	}

	@Override
	public List<Object[]> findTenderBidCount() {
		String sql  = """
						select 
							t.tender_id as id,
							t.tender_number as tenderNumber,
							t.title as title,
							t.status as status,
							count(b.bid_id) as bidCount
						from tender t 
							left join bid b on t.tender_id = b.tender_id
								GROUP BY
									t.tender_id,
									t.tender_number ,
									t.title,
									t.status
								
							""";
		Query query = entityManager.createNativeQuery(sql);
		
		
		return query.getResultList();
	}

	
	
	
//Tender bid statistics	
	@Override
	public List<Object[]> findTenderBidStatistics() {
		String sql = """
						select 
							t.tender_number as tenderNumber,
							t.title as title,
							MIN(b.bid_amount) as lowestAmount,
							MAX(b.bid_amount) as highestAmount,
							AVG(b.bid_amount) as avrageAmount
				from tender t 
						join bid b on t.tender_id = b.tender_id
				GROUP BY 
						t.tender_id,
						t.tender_number,
						t.title
						
				""";
		Query query =entityManager.createNativeQuery(sql);
		
		return query.getResultList();
	}

	@Override
	public List<Tuple> findTenderItemOrganizationBids() {
		
		String sql ="""
				
					SELECT 
						t.tender_id as id,
						t.tender_number as tenderNumber,
						t.title as title,
						t.status as status,
						t.estimated_value as estimatedValue,
						o.organization_name as organizationName,
						o.department as department,
						COUNT(ti.tender_item_id) as totalItem,
						COUNT(b.bid_id) as totalBids,
						MIN(b.bid_amount) as lowestBid,
						MAX(b.bid_amount) as highestBid
				FROM tender t 
					JOIN organization o ON t.organization_id = o.organization_id
					JOIN tender_item ti ON t.tender_id =ti.tender_id
					JOIN bid b ON t.tender_id = b.tender_id
				GROUP BY 
						t.tender_id,
						t.tender_number,
						t.title,
						t.status,
						t.estimated_value,
						o.organization_name,
						o.department
			
				""";
		Query query = entityManager.createNativeQuery(sql,Tuple.class);
		
		return query.getResultList();
	}
	
	
	
}