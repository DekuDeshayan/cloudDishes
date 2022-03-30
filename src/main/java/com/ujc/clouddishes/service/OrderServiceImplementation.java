package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ujc.clouddishes.repository.OrderRepository;

import lombok.Data;

@Data
public class OrderServiceImplementation implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
}
