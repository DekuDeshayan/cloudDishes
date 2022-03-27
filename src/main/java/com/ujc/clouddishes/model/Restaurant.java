package com.ujc.clouddishes.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ujc.clouddishes.model.enums.Province;

import lombok.Data;

@Data
@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length =100)
	private Province province;
	
	@Column(nullable = false, length =100)
	private String district;
	
	@Column(nullable = false, length =100)
	private String neighborhood;
	
	@Column(nullable = false, length =100)
	private String street;
	
	@Column(nullable = false, length =100)
	private String avenue;

	@Column(nullable = false, length =100)
	private String imageTitle;
	
	@Column (nullable = false)
	private Integer openTime;
	
	@Column (nullable = false)
	private Integer closeTime;
	
	@Column(nullable = false)
	private LocalDateTime creatTime;
	
	

}
