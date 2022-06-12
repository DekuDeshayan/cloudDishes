package com.ujc.clouddishes.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujc.clouddishes.model.Restaurant;
import com.ujc.clouddishes.repository.RestaurantRepository;
import com.ujc.clouddishes.repository.projections.RestaurantListByGeoLocation;

@Service
public class RestaurantServiceImplementation implements RestaurantService {
	


	@Autowired
	private RestaurantRepository restaurantRepository;	
	
	@Override
	public Optional<Restaurant> findById(Long id) {
		return restaurantRepository.findById(id);
	}
	
	@Override
	public Restaurant saveRestaurant(String restaurant, MultipartFile restaurantImage, String restaurantImageUrl) {
		
		Restaurant restaurantJson = new Restaurant();
		
		try {
			
			ObjectMapper objectMapper = new ObjectMapper();
			restaurantJson = objectMapper.readValue(restaurant, Restaurant.class);
			
		}catch(Exception excep) {
			
			System.out.printf("Error",excep.toString());
			
		}
		
		restaurantJson.setCreateTime(LocalDateTime.now());
		
		restaurantJson.setImageName(restaurantImage.getOriginalFilename());
		
		restaurantJson.setImageUrl(restaurantImageUrl);
				
		return restaurantRepository.save(restaurantJson);

	}

	@Override
	public Restaurant saveRestaurantNoImage(String restaurant) {
		
		Restaurant restaurantJson = new Restaurant();
		
		try {
			
			ObjectMapper objectMapper = new ObjectMapper();
			restaurantJson = objectMapper.readValue(restaurant, Restaurant.class);
			
		}catch(Exception excep) {
			
			System.out.printf("Error",excep.toString());
			
		}
		
		
		restaurantJson.setCreateTime(LocalDateTime.now());
		
		restaurantJson.setImageName("default24052022.png");
		
		restaurantJson.setImageUrl("http://localhost:8080/api/restaurant/files/default24052022.png");
				
		return restaurantRepository.save(restaurantJson);

	}


	@Override
	public List<RestaurantListByGeoLocation> retrieveRestaurantListByGeolocation(Integer provinceCode, Integer districtCode, Integer neighborhoodCode) {
		
		return restaurantRepository.retrieveRestaurantListByGeolocation(provinceCode, districtCode, neighborhoodCode);
	}

	@Override
	public List<Restaurant> findAll() {
		
		return restaurantRepository.findAll();
	}

	

}
