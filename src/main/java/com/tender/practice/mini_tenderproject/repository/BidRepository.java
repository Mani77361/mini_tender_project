package com.tender.practice.mini_tenderproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tender.practice.mini_tenderproject.entity.Bid;

public interface BidRepository extends JpaRepository<Bid, Long> {

}
