package com.ujc.clouddishes.repository.projections;

import com.ujc.clouddishes.model.enums.Mealtype;

public interface MealListByName {
	
	String getName();
	String getDescription();
	Mealtype getMealtype();
	String getImageTitle();
	Integer getPreparationTime();
	Double getPrice();

}
