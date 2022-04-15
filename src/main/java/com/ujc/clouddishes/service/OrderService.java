package com.ujc.clouddishes.service;

import java.util.List;

import com.ujc.clouddishes.model.Order;
import com.ujc.clouddishes.model.Request;

public interface OrderService {
	
	List<Order> findAllOrders();
	
	
	
	Order saveOrder(Order order,  Request request, Long mealId,Long user_id);
}
