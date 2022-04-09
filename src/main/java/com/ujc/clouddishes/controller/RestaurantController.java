package com.ujc.clouddishes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.clouddishes.model.Restaurant;
import com.ujc.clouddishes.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurant/")//url padrao da api
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("save")//api/restaurant/save
	public ResponseEntity<?> saveRestaurant(@RequestBody Restaurant restaurant){
		
		return new ResponseEntity<>(restaurantService.saveRestaurant(restaurant), HttpStatus.CREATED);
	}

}
