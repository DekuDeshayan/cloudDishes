package com.ujc.clouddishes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.clouddishes.model.Request;
import com.ujc.clouddishes.model.Reservation;
import com.ujc.clouddishes.security.UserPrincipal;
import com.ujc.clouddishes.service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	
	
	@PostMapping("save/{mealId}")//api/reservation/save/{mealId}
	public ResponseEntity<?> saveReservation(@RequestBody Reservation reservation, Request request, @PathVariable Long mealId, @AuthenticationPrincipal UserPrincipal userPrincipal){
		
		return new ResponseEntity<>(reservationService.saveReservation(reservation, request, mealId,userPrincipal.getId()), HttpStatus.CREATED);
	}
	
	@GetMapping("find-all-reservations")//api/reservation/find-all-reservations
	public ResponseEntity<?> findAllReservations(){
		
		return new ResponseEntity<>(reservationService.findAllReservations(), HttpStatus.OK);
	}
	

}
