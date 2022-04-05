package com.ujc.clouddishes.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ujc.clouddishes.model.enums.RequestStatus;

import lombok.Data;

@Data
@Entity
@Table(name = "request")
public class Request {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RequestStatus requestStatus;
	
	@Column(nullable = false)
	private String description;
	
	@OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
	private Reservation reservation;
	
	@OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
	private Order order;
	
	

	
}
