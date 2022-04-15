package com.ujc.clouddishes.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.model.Meal;
import com.ujc.clouddishes.model.Order;
import com.ujc.clouddishes.model.Request;
import com.ujc.clouddishes.model.enums.RequestStatus;
import com.ujc.clouddishes.repository.MealRepository;
import com.ujc.clouddishes.repository.OrderRepository;
import com.ujc.clouddishes.repository.RequestRepository;

@Service
public class OrderServiceImplementation implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private MealRepository mealRepository;
	
	private final String Order_prefix = "Order_";
	
	
	
	@Override
	public Order saveOrder(Order order, Request request, Long mealId, Long user_id) {
		
		Optional<Meal> meal = mealRepository.findById(mealId);
		
		order.setOrderTime(LocalDateTime.now());
		order.setUser_id(user_id);
		
		request.setDescription(Order_prefix + order.getDescription());
		request.setRequestStatus(RequestStatus.PENDING);
		request.setRequestTime(order.getOrderTime());
		
		requestRepository.save(request);
		
		order.setRequest_id(request.getId());
		
		order.getMeal().add(meal.get());
		
		return orderRepository.save(order);
	}

	
	@Override
	public List<Order> findAllOrders() {
		
		return orderRepository.findAll();
	}
}
