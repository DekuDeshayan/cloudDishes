package com.ujc.clouddishes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujc.clouddishes.model.Meal;
import com.ujc.clouddishes.repository.projections.MealListByName;

public interface MealRepository extends JpaRepository<Meal, Long> {
	
	//must be search,have to be changed to like clause
	@Query("SELECT m FROM Meal m WHERE m.name = :name")
	List<MealListByName> retrieveMealListByName(@Param("name") String name);

}
