package com.tender.practice.mini_tenderproject.repository;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tender.practice.mini_tenderproject.TenderStatusProjection.TenderStatusProjection;
import com.tender.practice.mini_tenderproject.dto.TenderOrganizationResponse;
import com.tender.practice.mini_tenderproject.dto.TenderResponse;
import com.tender.practice.mini_tenderproject.dto.TenderStatusRequest;
import com.tender.practice.mini_tenderproject.dto.TenderStatusResponse;
import com.tender.practice.mini_tenderproject.entity.Tender;
import com.tender.practice.mini_tenderproject.projection.TenderItemViewProjection;

public interface TenderRepository extends JpaRepository<Tender,Long>{
	
	List<Tender> findTenderByStatus(String status);
	
	@Query(value = "select * from tender where title =:title",
			nativeQuery = true)
	List<Tender> findByTitleContainingIgnoreCase(@Param("title") String title);
	
	@Query("SELECT t FROM Tender t WHERE t.title = :title AND t.status =:status")
	List<Tender> findTenderByTitleAndStatus(@Param("title") String title,
										@Param("status") String status);
	
//native Query
	/*
	 * @Query(value = """
	 * 
	 * SELECT * FROM tender WHERE status = 'OPEN' AND closing_date >= CURRENT_DATE
	 * AND closing_date <= CURRENT_DATE + (:days * INTERVAL '5 days') """,
	 * nativeQuery = true )
	 */
	
	//jpql query 
	
	  @Query(""" 
	  		
	  		SELECT t FROM Tender t WHERE t.status ='OPEN'
			  	And t.closingDate >= :today 
			  	AND t.closingDate <= :endDate """)
	 
	List<Tender> findOpenTenderByClosingWithInDays(@Param("today") LocalDate today,
																@Param("endDate") LocalDate endDate);
	  
	/*
	 * @Query(""" SELECT t,o FROM Tender t ,organization o WHERE t.organizationId =
	 * o.organizationId AND o.organizationId = :organizationId """) List<Tender>
	 * getTenderCreatedByPerticularOrganization(@Param("organizationId") Long
	 * organizationId);
	 */
	  
	  
	  
	  
	  @Query(value = """
	  		SELECT t.tender_id As tenderId
	  		,ti.tender_item_id As tenderItemId
	  		,t.title As tenderName
	  		,t.published_date As publishDate,
	  		ti.quantity As quantity,
	  		ti.unit_price As unit_price 
	  		 		FROM tender t JOIN tender_item ti ON t.tender_id= ti.tender_id""",
	  		nativeQuery = true)
	  List<TenderItemViewProjection> getTenderItemDetails();
	  
	  
	  List<Tender> findByStatusIn(List<String> statuses);
	  
	  
	  @Query(value = """
	  			SELECT t.tender_id AS tenderId,
				t.title AS title,
				t.description AS description,
				t.status AS status,
				ti.tender_item_id AS tenderItemId ,
				ti.quantity AS quantity,
				ti.unit AS unit ,
				ti.unit_price AS price FROM tender t JOIN tender_item ti ON t.tender_id = ti.tender_id 
		  		where t.status IN (:statuses)
		  		""",
					nativeQuery = true)
	 
	  List<TenderStatusProjection> findTenderStatusDetails(@Param("statuses") List<String> statuses);
	  
	  
	  @Query("""
	  		SELECT new com.tender.practice.mini_tenderproject.dto.TenderOrganizationResponse(t.tenderNumber,t.title,t.status,o.organizationName,o.department) FROM Tender t JOIN t.organization o 
	  		""")
	  List<TenderOrganizationResponse> findTenderOrgaqnizationDetails();
	  
	  
	  
}
