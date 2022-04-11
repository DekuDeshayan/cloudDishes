package com.ujc.clouddishes.repository.projections;

import com.ujc.clouddishes.model.enums.District;
import com.ujc.clouddishes.model.enums.Neighborhood;
import com.ujc.clouddishes.model.enums.Province;

public interface RestaurantListByGeoLocalization {
	
	String getName();
	Province getProvince();
	District getDistrict();
	Neighborhood getNeighborhood();
	String getImageTitle();
	Integer getOpenTime();
	Integer getCloseTime();
}
