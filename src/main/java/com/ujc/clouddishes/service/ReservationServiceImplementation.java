package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ujc.clouddishes.repository.ReservationRepository;

import lombok.Data;

@Data
public class ReservationServiceImplementation implements ReservationService {
	
	
	@Autowired
	private ReservationRepository reservationRepository;
	

}
