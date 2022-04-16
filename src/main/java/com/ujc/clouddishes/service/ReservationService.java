package com.ujc.clouddishes.service;

import java.util.List;

import com.ujc.clouddishes.model.Request;
import com.ujc.clouddishes.model.Reservation;

public interface ReservationService {

	
	List<Reservation> findAllReservations();
	
	Reservation saveReservation(Reservation reservation, Request request, Long mealId, Long user_id);

}
