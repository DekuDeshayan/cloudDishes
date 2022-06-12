package com.ujc.clouddishes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujc.clouddishes.model.Meal;
import com.ujc.clouddishes.repository.projections.SearchedMeals;

public interface MealRepository extends JpaRepository<Meal, Long> {
	
	
	@Query("SELECT m FROM Meal m WHERE m.name like %:name%")
	List<SearchedMeals> searchMeals(@Param("name") String name);
	
	@Query("SELECT m FROM Meal m WHERE m.restaurant_id=:rest_id")
	List<Meal> retrieveMealListByRestaurant(@Param("rest_id") Long rest_id);

}
