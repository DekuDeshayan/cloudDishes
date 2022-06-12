package com.ujc.clouddishes.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujc.clouddishes.model.Meal;
import com.ujc.clouddishes.repository.MealRepository;
import com.ujc.clouddishes.repository.projections.SearchedMeals;

@Service
public class MealServiceImplementation implements MealService {
	
	@Autowired
	private MealRepository mealRepository;
	

	@Override
	public Meal saveMeal(String meal, MultipartFile mealImage, String mealImageUrl) {
		
		Meal mealJson = new Meal();
		
		try {
			
			ObjectMapper objectMapper = new ObjectMapper();
			mealJson = objectMapper.readValue(meal, Meal.class);
			
		}catch(Exception excep) {
			
			System.out.printf("Error",excep.toString());
			
		}
		
		
		mealJson.setCreateTime(LocalDateTime.now());
		
		mealJson.setImageName(mealImage.getOriginalFilename());
		
		mealJson.setImageUrl(mealImageUrl);
				
		return mealRepository.save(mealJson);
		
	}


	@Override
	public Meal saveMealNoImage(String meal) {
		
		Meal mealJson = new Meal();
		
		try {
			
			ObjectMapper objectMapper = new ObjectMapper();
			mealJson = objectMapper.readValue(meal, Meal.class);
			
		}catch(Exception excep) {
			
			System.out.printf("Error",excep.toString());
			
		}
		
		
		mealJson.setCreateTime(LocalDateTime.now());
		
		mealJson.setImageName("default24052022.png");
		
		mealJson.setImageUrl("http://localhost:8080/api/meal/files/default24052022.png");
				
		return mealRepository.save(mealJson);
		
	}





	@Override
	public Optional<Meal> findByID(Long mealId) {

		return mealRepository.findById(mealId);
	}



	@Override
	public List<SearchedMeals> searchMeals(String name){
		
		return mealRepository.searchMeals(name);
	}

	
	@Override
	public List<Meal> retrieveMealListByRestaurant(Long id) {
		
		return mealRepository.retrieveMealListByRestaurant(id);
	}


	@Override
	public List<Meal> findAllMeals(){
		
		return mealRepository.findAll();
				
	}
	
	

}
