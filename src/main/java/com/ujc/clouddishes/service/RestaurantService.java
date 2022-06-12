package com.ujc.clouddishes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.ujc.clouddishes.model.Restaurant;
import com.ujc.clouddishes.repository.projections.RestaurantListByGeoLocation;

public interface RestaurantService {
	
	Restaurant saveRestaurant(String restaurant, MultipartFile restaurantImage, String restaurantImageUrl);

	Restaurant saveRestaurantNoImage(String restaurant);

	List<RestaurantListByGeoLocation> retrieveRestaurantListByGeolocation(Integer provinceCode, Integer districtCode, Integer neighborhoodCode);

	List<Restaurant> findAll();
	
	Optional<Restaurant>findById(Long id);
	
}
