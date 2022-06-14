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
import com.ujc.clouddishes.dto.MealDTO;
import com.ujc.clouddishes.model.enums.Mealtype;

import lombok.Data;

@Data
@Entity
@Table(name = "meal")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Meal {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Mealtype mealType;
	
	@Column(nullable = false, length = 10)
	private String description;
	
	@Column (nullable = false)
	private double price;
	
	@Column(nullable = false)
	private Integer preparationTime;
	
	@Column(nullable = false)
	private LocalDateTime createTime;
	
	
	@Column(length = 100)
	private String imageName;
	
	@Column
	private String imageUrl;
	
	
	@Column(name="restaurant_id", nullable = false)
	private Long restaurant_id;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name="restaurant_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Restaurant restaurant;
	
	
	public Meal() {
		super();
	}
	
	public Meal(MealDTO meal) {
		super();
		
		this.id = meal.getId();
		this.price = meal.getPrice();
		this.description = meal.getDescription();
		this.name = meal.getName();
		this.preparationTime = meal.getPreparationTime();
		this.price = meal.getPrice();
		this.mealType = meal.getMealType();
		this.imageName = meal.getImageName();
		this.imageUrl = meal.getImageUrl();
		this.createTime = meal.getCreateTime();
		this.restaurant_id = meal.getRestaurant_id();
	}
	



}
