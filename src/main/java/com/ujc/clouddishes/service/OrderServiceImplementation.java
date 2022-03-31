package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.repository.OrderRepository;

@Service
public class OrderServiceImplementation implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
}
