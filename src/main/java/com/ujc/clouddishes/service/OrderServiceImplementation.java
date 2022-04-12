package com.ujc.clouddishes.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.model.Order;
import com.ujc.clouddishes.model.Request;
import com.ujc.clouddishes.model.enums.RequestStatus;
import com.ujc.clouddishes.repository.OrderRepository;
import com.ujc.clouddishes.repository.RequestRepository;

@Service
public class OrderServiceImplementation implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	//private RequestRepository requestRepository;
	
	
	@Override
	public Order saveOrder(Order order, Long user_id ) {
		
		Request request = new Request();
				
		order.setOrdertime(LocalDateTime.now());
		request.setDescription(order.getDescription());
		request.setRequestStatus(RequestStatus.PENDING);
		order.setRequest(request);			
		
		order.setUserId(user_id);
		
		return orderRepository.save(order);
	}
}
