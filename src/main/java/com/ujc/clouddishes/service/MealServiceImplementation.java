package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.repository.MealRepository;

@Service
public class MealServiceImplementation implements MealService {
	
	@Autowired
	private MealRepository mealRepository; 

}
