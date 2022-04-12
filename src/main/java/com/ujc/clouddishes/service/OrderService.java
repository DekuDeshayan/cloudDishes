package com.ujc.clouddishes.service;

import com.ujc.clouddishes.model.Order;

public interface OrderService {
	Order saveOrder(Order order, Long user_id);

}
