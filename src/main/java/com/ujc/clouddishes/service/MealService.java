package com.ujc.clouddishes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.ujc.clouddishes.model.Meal;
import com.ujc.clouddishes.repository.projections.SearchedMeals;

public interface MealService {
	
	Meal saveMeal(String meal, MultipartFile mealImage, String mealImageUrl);
	
	Meal saveMealNoImage(String meal);
	
	Optional<Meal> findByID(Long mealId);
	
	List<Meal> findAllMeals();
	
	List<Meal> retrieveMealListByRestaurant(Long id);

	List<SearchedMeals> searchMeals(String name);

}
