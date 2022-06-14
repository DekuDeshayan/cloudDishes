package com.ujc.clouddishes.dto;

import java.time.LocalDateTime;

import com.ujc.clouddishes.model.Meal;
import com.ujc.clouddishes.model.enums.Mealtype;

import lombok.Data;

@Data
public class MealDTO {

	private String name;
	private Mealtype mealType;
	private String description;
	private Double price;
	private Integer preparationTime;
	private LocalDateTime createTime;
	private String imageName;
	private String imageUrl;
	private Long id;
	private Long restaurant_id;
	
	
	public MealDTO() {
		super();
	}
	
	public MealDTO(Meal meal) {
		super();
		this.id = meal.getId();
		this.price = meal.getPrice();
		this.description = meal.getDescription();
		this.name = meal.getName();
		this.preparationTime = meal.getPreparationTime();
		this.price = meal.getPrice();
		this.mealType = meal.getMealType();
		this.imageName = meal.getImageName();
		this.imageUrl = meal.getImageUrl();
		this.createTime = meal.getCreateTime();
		this.restaurant_id = meal.getRestaurant_id();
	}
	

}
