package com.ujc.clouddishes.service;

import java.util.List;

import com.ujc.clouddishes.model.Restaurant;
import com.ujc.clouddishes.model.enums.Province;
import com.ujc.clouddishes.repository.projections.RestaurantListByGeoLocalization;

public interface RestaurantService {
	
	Restaurant saveRestaurant(Restaurant restaurant);
	
	List<RestaurantListByGeoLocalization> retrieveRestaurantListByGeolocalization(Integer provinceCode);

}
