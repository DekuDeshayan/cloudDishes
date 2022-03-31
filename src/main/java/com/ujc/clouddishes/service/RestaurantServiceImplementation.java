package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.repository.RestaurantRepository;
@Service
public class RestaurantServiceImplementation implements RestaurantService {
	
	//Dependecy Injection
	@Autowired
	private RestaurantRepository restaurantRepository;

}
