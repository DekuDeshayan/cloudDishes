package com.ujc.clouddishes.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ujc.clouddishes.model.enums.District;
import com.ujc.clouddishes.model.enums.Neighborhood;
import com.ujc.clouddishes.model.enums.Province;

import lombok.Data;

@Data
@Entity
@Table(name="restaurant")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length =100)
	private Province province;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length =100)
	private District district;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length =100)
	private Neighborhood neighborhood;
	
	@Column(nullable = false, length =100)
	private String imageTitle;
	
	@Column (nullable = false)
	private Integer openTime;
	
	@Column (nullable = false)
	private Integer closeTime;
	
	@Column(nullable = false)
	private LocalDateTime creatTime;
	
	@OneToMany(mappedBy = "restaurant", fetch =  FetchType.LAZY)
	private Set<Order> order;
	
	@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
	private Set<Reservation> reservation;


}
