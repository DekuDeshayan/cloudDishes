package com.ujc.clouddishes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@GetMapping("retrieve-rest-by-geo/{provinceCode}")//api/restaurant/retrieve-rest-by-geo/{province}
	public ResponseEntity<?> retrieveRestaurantListByGeolocalization(@PathVariable Integer provinceCode){
		return ResponseEntity.ok(restaurantService.retrieveRestaurantListByGeolocalization(provinceCode));
		//return new ResponseEntity<>(restaurantService.retrieveRestaurantListByGeolocalization(province), HttpStatus.OK);
	}

}
