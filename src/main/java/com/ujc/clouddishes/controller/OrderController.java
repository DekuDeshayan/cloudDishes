package com.ujc.clouddishes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.clouddishes.model.Order;
import com.ujc.clouddishes.model.Request;
import com.ujc.clouddishes.security.UserPrincipal;
import com.ujc.clouddishes.service.OrderService;

@RestController
@RequestMapping("/api/order/")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	
	@PostMapping("save/{mealId}")//api/order/save/{mealId}
	public ResponseEntity<?> saveOrder(@RequestBody Order order, Request request, @PathVariable Long mealId, @AuthenticationPrincipal UserPrincipal userPrincipal){
		
		return new ResponseEntity<>(orderService.saveOrder(order, request, mealId, userPrincipal.getId()), HttpStatus.CREATED);
		//(Order order, Request request, Long mealId, Long user_id) 
	}
	
	@GetMapping("find-all-orders")//api/order/find-all-orders
	public ResponseEntity<?> findAllOrders(){
		
		return new ResponseEntity<>(orderService.findAllOrders(), HttpStatus.OK);
	}

}
