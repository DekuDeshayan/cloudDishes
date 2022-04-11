package com.ujc.clouddishes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.clouddishes.model.Meal;
import com.ujc.clouddishes.service.MealService;

@RestController
@RequestMapping("/api/meal")
public class MealController {
	@Autowired
	private MealService mealService;

	@PostMapping("save")
	public ResponseEntity<?> saveMeal (@RequestBody Meal meal){
		return  new ResponseEntity<>(mealService.saveMeal(meal),HttpStatus.CREATED);	
	}
}
