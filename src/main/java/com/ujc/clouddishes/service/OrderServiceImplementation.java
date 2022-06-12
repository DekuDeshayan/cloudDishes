package com.ujc.clouddishes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.model.Meal;
import com.ujc.clouddishes.model.Order;
import com.ujc.clouddishes.model.OrderDeliveryAddress;
import com.ujc.clouddishes.model.Request;
import com.ujc.clouddishes.model.enums.RequestStatus;
import com.ujc.clouddishes.repository.OrderRepository;
import com.ujc.clouddishes.repository.RequestRepository;

@Service
public class OrderServiceImplementation implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RequestRepository requestRepository;

	private final String Order_prefix = "Order_";
	
	
	
	@Override
	public Order saveOrder(Order order, OrderDeliveryAddress address, List<Meal> meals, Request request, Long user_id) {

		//Optional<Meal> meal = mealRepository.findById(mealId);

		
		order.setOrderTime(LocalDateTime.now());
		order.setUser_id(user_id);
		
		request.setDescription(Order_prefix + order.getDescription());
		request.setRequestStatus(RequestStatus.PENDING);
		request.setRequestTime(order.getOrderTime());
		
		requestRepository.save(request);
		
		order.setRequest_id(request.getId());

		order.getMeal().addAll(meals);
		
		return orderRepository.save(order);
	}

	
	@Override
	public List<Order> findAllOrders() {
		
		return orderRepository.findAll();
	}


}
