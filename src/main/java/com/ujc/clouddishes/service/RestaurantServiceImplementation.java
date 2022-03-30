package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ujc.clouddishes.repository.RestaurantRepository;

import lombok.Data;
@Data
public class RestaurantServiceImplementation implements RestaurantService {
	
	//Dependecy Injection
	@Autowired
	private RestaurantRepository restaurantRepository;

}
