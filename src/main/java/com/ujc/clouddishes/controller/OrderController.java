package com.ujc.clouddishes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.clouddishes.model.Order;
import com.ujc.clouddishes.security.UserPrincipal;
import com.ujc.clouddishes.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("save") //api/order/save
	public ResponseEntity<?> saveOrder(@RequestBody Order order, @AuthenticationPrincipal UserPrincipal userPrincipal){
		
		
		return  new ResponseEntity<>(orderService.saveOrder(order,userPrincipal.getId()), HttpStatus.CREATED);
		
	}

}
