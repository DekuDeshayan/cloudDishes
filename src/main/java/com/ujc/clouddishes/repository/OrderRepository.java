package com.ujc.clouddishes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujc.clouddishes.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
		
	
		@Query("SELECT o FROM Order o WHERE o.user_id=:userId")
		List<Order> findAllOrdersOfUser(@Param("userId") Long userId);
		
}
