package com.ujc.clouddishes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujc.clouddishes.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

}
