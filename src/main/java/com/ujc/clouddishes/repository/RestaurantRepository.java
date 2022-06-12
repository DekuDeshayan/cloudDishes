package com.ujc.clouddishes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujc.clouddishes.model.Restaurant;
import com.ujc.clouddishes.repository.projections.RestaurantListByGeoLocation;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	
	
	@Query("SELECT r FROM Restaurant r WHERE r.province = :provinceCode and r.district =:districtCode and r.neighborhood =:neighborhoodCode")
	List<RestaurantListByGeoLocation> retrieveRestaurantListByGeolocation(@Param("provinceCode") Integer provinceCode, @Param("districtCode") Integer districtCode, @Param("neighborhoodCode") Integer neighborhoodCode);


}

