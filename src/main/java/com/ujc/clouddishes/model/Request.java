package com.ujc.clouddishes.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ujc.clouddishes.model.enums.RequestStatus;

import lombok.Data;

@Data
@Entity
@Table(name = "request")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Request {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RequestStatus requestStatus;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private LocalDateTime requestTime;
	
	/*
		@OneToOne(mappedBy = "request")
		private Reservation reservation;
	*/
	
	/*
		@OneToOne(mappedBy = "request")
		private Order order;
	*/
	

	
}
