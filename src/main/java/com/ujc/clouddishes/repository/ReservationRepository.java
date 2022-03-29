package com.ujc.clouddishes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujc.clouddishes.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
