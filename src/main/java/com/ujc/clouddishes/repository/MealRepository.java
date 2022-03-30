package com.ujc.clouddishes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujc.clouddishes.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {

}
