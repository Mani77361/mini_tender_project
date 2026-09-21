package com.tender.practice.mini_tenderproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tender.practice.mini_tenderproject.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUserName(String userName);

	
	Optional<User> findByEmail(String email);
}
