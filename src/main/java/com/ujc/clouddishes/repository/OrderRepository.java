package com.ujc.clouddishes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujc.clouddishes.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	

}
