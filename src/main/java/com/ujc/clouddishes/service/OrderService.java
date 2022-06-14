package com.ujc.clouddishes.service;

import java.util.List;

import com.ujc.clouddishes.dto.OrderRequestDTO;
import com.ujc.clouddishes.model.Order;

public interface OrderService {
	
	List<Order> findAllOrders();

	List<Order> findAllOrdersOfUser(Long userId);
	
	Order saveOrder(OrderRequestDTO orderDto, Long user_id);
}
