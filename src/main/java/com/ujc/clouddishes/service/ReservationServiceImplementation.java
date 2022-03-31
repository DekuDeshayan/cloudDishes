package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.repository.ReservationRepository;

@Service
public class ReservationServiceImplementation implements ReservationService {
	
	
	@Autowired
	private ReservationRepository reservationRepository;
	

}
