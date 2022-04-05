package com.ujc.clouddishes.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDateTime reservationtime;
	
	@Column(nullable = false)
	private String description;
	
	@ManyToMany
	@JoinTable(name = "reservation_meal", joinColumns = @JoinColumn(name = "meal_id"), inverseJoinColumns = @JoinColumn(name = "reservation_id"))
	private Set<Meal> meal = new HashSet<>();
	
	@OneToOne
	@MapsId
	private Request request;
	
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name="user_id", referencedColumnName = "id")
	private User user;
	
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name="restaurant_id", referencedColumnName = "id")
	private Restaurant restaurant;
	
	
	

	
}
