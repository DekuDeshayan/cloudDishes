package com.ujc.clouddishes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujc.clouddishes.model.Restaurant;
import com.ujc.clouddishes.repository.projections.RestaurantListByGeoLocalization;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	
	
	@Query("SELECT r FROM Restaurant r WHERE r.province = :provinceCode")
	List<RestaurantListByGeoLocalization> retrieveRestaurantListByGeolocalization(@Param("provinceCode") Integer provinceCode);
	
	/*
	@Query("SELECT name, province, district, neighborhood, imageTitle, openTime, closeTime " +
            "FROM Restaurant " +
            "WHERE province LIKE :province")
	List<RestaurantSearch> retrieveRestaurantListByGeolocalization(@Param("province") Province province);
	*/

}

