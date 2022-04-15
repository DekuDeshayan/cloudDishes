package com.ujc.clouddishes.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@Column(nullable = false)
	private LocalDateTime orderTime;
	
	@Column(nullable = false)
	private String description;
	

	
	@ManyToMany
	@JoinTable(name = "order_meal", joinColumns = @JoinColumn(name = "meal_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private Set<Meal> meal = new HashSet<>();
	

	//fk- é a criacao da foreign key como no mysql: user_id int
	@Column(nullable = false)
	private Long request_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "request_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Request request;
	

	
	//fk- é a criacao da foreign key como no mysql: user_id int
	@Column(name="user_id", nullable = false)
	private Long user_id;
	
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	
}
