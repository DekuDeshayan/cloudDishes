package com.ujc.clouddishes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.model.Meal;
import com.ujc.clouddishes.repository.MealRepository;
import com.ujc.clouddishes.repository.projections.MealListByName;

@Service
public class MealServiceImplementation implements MealService {
	
	@Autowired
	private MealRepository mealRepository;

	@Override
	public Meal saveMeal(Meal meal) {
		
		meal.setCreatTime(LocalDateTime.now());
		
		return mealRepository.save(meal);
	}
	
	@Override
	public List<MealListByName> retrieveMealListByName(String name){
		
		return mealRepository.retrieveMealListByName(name);
	}


	
	

}
