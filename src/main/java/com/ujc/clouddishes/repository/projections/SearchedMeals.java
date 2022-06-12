package com.ujc.clouddishes.repository.projections;

import com.ujc.clouddishes.model.enums.Mealtype;

public interface SearchedMeals {
	
	String getName();
	String getDescription();
	Mealtype getMealType();
	Integer getPreparationTime();
	Double getPrice();

}
 