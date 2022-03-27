package com.ujc.clouddishes.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ujc.clouddishes.model.enums.Mealtype;

public class Meal {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false)
	private Mealtype mealtype;
	
	@Column(nullable = false, length = 100)
	private String description;
	
	@Column (nullable = false)
	private double price;
	
	@Column(nullable = false)
	private Integer preparationTime;
	
	@Column(nullable = false, length =100)
	private String imageTitle;
	
	@Column(nullable = false)
	private LocalDateTime creatTime;

}
