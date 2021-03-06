package com.ujc.clouddishes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.clouddishes.dto.OrderRequestDTO;
import com.ujc.clouddishes.security.UserPrincipal;
import com.ujc.clouddishes.service.OrderService;


@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("save")//api/order/save
	public ResponseEntity<?> saveOrder(@RequestBody OrderRequestDTO orderRequest, @AuthenticationPrincipal UserPrincipal userPrincipal){
		
		return new ResponseEntity<>(orderService.saveOrder(orderRequest, userPrincipal.getId()), HttpStatus.CREATED);
		
	}
	

	
	
	@GetMapping("find-all-orders")//api/order/find-all-orders
	public ResponseEntity<?> findAllOrders(){
		
		return new ResponseEntity<>(orderService.findAllOrders(), HttpStatus.OK);
	}	
	
	@GetMapping("findUserOrders")//api/order/findUserOrders
	public ResponseEntity<?> findAllOrdersOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
		return new ResponseEntity<>(orderService.findAllOrdersOfUser(userPrincipal.getId()), HttpStatus.OK);
	}
	
	
	
	
	

}

