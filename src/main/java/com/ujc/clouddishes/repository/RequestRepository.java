package com.ujc.clouddishes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujc.clouddishes.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long>{
	
	

}
