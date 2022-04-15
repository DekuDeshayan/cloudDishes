package com.ujc.clouddishes.service;

import java.util.List;
import java.util.Optional;

import com.ujc.clouddishes.model.Meal;
import com.ujc.clouddishes.repository.projections.MealListByName;

public interface MealService {
	
	Meal saveMeal(Meal meal);
	Optional<Meal> findByID(Long mealId);
	List<MealListByName> retrieveMealListByName(String name);

}
