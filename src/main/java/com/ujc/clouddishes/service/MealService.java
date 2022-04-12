package com.ujc.clouddishes.service;

import java.util.List;

import com.ujc.clouddishes.model.Meal;
import com.ujc.clouddishes.repository.projections.MealListByName;

public interface MealService {
	
	Meal saveMeal(Meal meal);

	List<MealListByName> retrieveMealListByName(String name);

}
