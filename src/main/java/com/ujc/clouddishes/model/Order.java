package com.ujc.clouddishes.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDateTime ordertime;
	
	@Column(nullable = false)
	private String description;
	
	@ManyToMany
	@JoinTable(name = "order_meal", joinColumns = @JoinColumn(name = "meal_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private Set<Meal> meal;
	
	@MapsId
	@OneToOne
	private Request request;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id", referencedColumnName = "id")
	private Restaurant restaurant;
	
	
	@ManyToOne
	@JoinColumn(name ="client_id", referencedColumnName = "id")
	private Client client;
	
}
