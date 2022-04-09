package com.ujc.clouddishes.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.model.Restaurant;
import com.ujc.clouddishes.repository.RestaurantRepository;

@Service
public class RestaurantServiceImplementation implements RestaurantService {
	
	//Dependecy Injection
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {
		
		restaurant.setCreatTime(LocalDateTime.now());
		return restaurantRepository.save(restaurant);
		
	}
	
	

}
