package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ujc.clouddishes.repository.MealRepository;

import lombok.Data;

@Data
public class MealServiceImplementation implements MealService {
	
	@Autowired
	private MealRepository mealRepository; 

}
