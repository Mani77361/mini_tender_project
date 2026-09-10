package com.tender.practice.mini_tenderproject.repository;

import java.util.List;

import com.tender.practice.mini_tenderproject.entity.Tender;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class TenderCustomRepoImpl implements TenderCustomRepo{

	@PersistenceContext
	private EntityManager entityManager;



	@Override
	public List<Tender> findByStatus(String status) {
		
		return entityManager.createQuery("SELECT t FROM Tender t Where t.status = :status" ,Tender.class )
				.setParameter("status", status)
				.getResultList();
	}




	@Override
	public List<Tender> findTenderByTitle(String title) {
		
		return entityManager.createQuery("SELECT t FROM Tender t Where t.title = :title" ,Tender.class)
				.setParameter("title", title)
				.getResultList();
	}




//	@SuppressWarnings("unchecked")
	@Override
	public List<Tender> findByStatuses(List<String> statuses) {
		
		
		return entityManager.createQuery("select t from Tender t where t.status IN (:statuses)" ,Tender.class)
				.setParameter("statuses", statuses)
				.getResultList();
		
		
	}
	

}


