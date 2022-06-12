package com.ujc.clouddishes.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.model.Meal;
import com.ujc.clouddishes.model.Request;
import com.ujc.clouddishes.model.Reservation;
import com.ujc.clouddishes.model.enums.RequestStatus;
import com.ujc.clouddishes.repository.MealRepository;
import com.ujc.clouddishes.repository.RequestRepository;
import com.ujc.clouddishes.repository.ReservationRepository;

@Service
public class ReservationServiceImplementation implements ReservationService {
	
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private MealRepository mealRepository;
	
	private final String Reservation_prefix = "Reservation_";
	
	@Override
	public Reservation saveReservation(Reservation reservation, Request request, Long mealId, Long user_id) {
		
		
		Optional<Meal> meal = mealRepository.findById(mealId);
		
		reservation.setReservationTime(LocalDateTime.now());
		reservation.setUser_id(user_id);
		
		request.setDescription(Reservation_prefix + reservation.getDescription());
		request.setRequestStatus(RequestStatus.PENDING);
		request.setRequestTime(reservation.getReservationTime());
		
		requestRepository.save(request);
		
		reservation.setRequest_id(request.getId());
		
		reservation.getMeal().add(meal.get());		
		
		
		return reservationRepository.save(reservation);
	}
	
	@Override
	public List<Reservation> findAllReservations(){
		
		return reservationRepository.findAll();
	}
	

}
