package com.ujc.clouddishes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.model.Restaurant;
import com.ujc.clouddishes.model.enums.Province;
import com.ujc.clouddishes.repository.RestaurantRepository;
import com.ujc.clouddishes.repository.projections.RestaurantListByGeoLocalization;

@Service
public class RestaurantServiceImplementation implements RestaurantService {
	
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {
		
		restaurant.setCreatTime(LocalDateTime.now());
		return restaurantRepository.save(restaurant);
		
	}

	@Override
	public List<RestaurantListByGeoLocalization> retrieveRestaurantListByGeolocalization(Integer provinceCode) {
		
		return restaurantRepository.retrieveRestaurantListByGeolocalization(provinceCode);
	}
	
	

}
