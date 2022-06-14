package com.ujc.clouddishes.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.dto.OrderRequestDTO;
import com.ujc.clouddishes.model.Meal;
import com.ujc.clouddishes.model.Order;
import com.ujc.clouddishes.model.OrderDeliveryAddress;
import com.ujc.clouddishes.model.Request;
import com.ujc.clouddishes.model.enums.RequestStatus;
import com.ujc.clouddishes.repository.OrderDeliveryAddressRepository;
import com.ujc.clouddishes.repository.OrderRepository;
import com.ujc.clouddishes.repository.RequestRepository;

@Service
public class OrderServiceImplementation implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RequestRepository requestRepository;

	@Autowired
	private OrderDeliveryAddressRepository OrderDeliveryAddressRepository;
	
	
	private final String Order_prefix = "Order_";
	
	
	
	@Override
	public Order saveOrder(OrderRequestDTO orderDto, Long user_id) {
		
		Order order = new Order();
		Request request = new Request();
		OrderDeliveryAddress address = new OrderDeliveryAddress();
		
		//saving delivery address
		address.setProvince(orderDto.getAddress().getProvince());
		address.setDistrict(orderDto.getAddress().getDistrict());
		address.setNeighborhood(orderDto.getAddress().getNeighborhood());
		address.setNickname(orderDto.getAddress().getNickname());
		address.setCompleteAddress(orderDto.getAddress().getCompleteAddress());
		
		OrderDeliveryAddressRepository.save(address);
		
		
		//saving  order details
		order.setAddress_id(address.getId());
		order.setDescription(orderDto.getOrder().getDescription());
		order.setSubtotal(orderDto.getOrder().getSubtotal());
		order.setOrderTime(LocalDateTime.now());
		order.setUser_id(user_id);
		List<Meal> cartItems = orderDto.getCartItems().stream().map(m -> new Meal(m)).collect(Collectors.toList());
		order.getMeal().addAll(cartItems);

		//saving request details
		request.setDescription(Order_prefix + order.getDescription());
		request.setRequestStatus(RequestStatus.PENDING);
		request.setRequestTime(order.getOrderTime());
		
		requestRepository.save(request);	
		
		order.setRequest_id(request.getId());
		
		
		return orderRepository.save(order);
	}

	
	@Override
	public List<Order> findAllOrders() {
		
		return orderRepository.findAll();
	}


	@Override
	public List<Order> findAllOrdersOfUser(Long userId) {
		return orderRepository.findAllOrdersOfUser(userId);
	}


}
