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
	private Long id;
	

	@Column(nullable = false)
	private LocalDateTime orderTime;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private double subtotal;
	
	
	@ManyToMany
	@JoinTable(name = "order_meal", joinColumns = @JoinColumn(name = "meal_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private Set<Meal> meal = new HashSet<>();
	
	
	@Column(name = "request_id", nullable = false)
	private Long request_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "request_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Request request;
	

	@Column(name="user_id", nullable = false)
	private Long user_id;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;
	
	
	@Column(name="address_id", nullable = false)
	private Long address_id;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name="address_id", referencedColumnName = "id", insertable = false, updatable = false)
	private OrderDeliveryAddress orderdeliveryaddress;
	
	
	

	
}
