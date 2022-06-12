package com.ujc.clouddishes.repository.projections;

import com.ujc.clouddishes.model.enums.District;
import com.ujc.clouddishes.model.enums.Neighborhood;
import com.ujc.clouddishes.model.enums.Province;

public interface RestaurantListByGeoLocation {
	
	String getName();
	Province getProvince();
	District getDistrict();
	Neighborhood getNeighborhood();
	String getImageUrl();
	Integer getOpenTime();
	Integer getCloseTime();
	String getPhone();
	String getEmail();
}
