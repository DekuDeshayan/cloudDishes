package com.ujc.clouddishes.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ujc.clouddishes.model.enums.Mealtype;

import lombok.Data;

@Data
@Entity
@Table(name = "meal")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Meal {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Mealtype mealType;
	
	@Column(nullable = false, length = 100)
	private String description;
	
	@Column (nullable = false)
	private double price;
	
	@Column(nullable = false)
	private Integer preparationTime;
	
	@Column(nullable = false, length =100)
	private String imageTitle;
	
	@Column(nullable = false)
	private LocalDateTime createTime;
	
	/*
		@ManyToMany(mappedBy = "meal")
		private Set<Order> order = new HashSet<>();
		
		@ManyToMany(mappedBy = "meal")
		private Set<Reservation> reservation = new HashSet<>();
	*/
	
	
	@Column(nullable = false)
	private Long restaurant_id;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name="restaurant_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Restaurant restaurant;
	
	

}
