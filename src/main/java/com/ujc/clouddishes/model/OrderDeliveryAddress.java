package com.ujc.clouddishes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Data
@Entity
@Table(name="order_delivery_address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderDeliveryAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nickname;
	
	@Column(nullable = false)
	private String province;
	
	@Column(nullable = false)
	private String neighborhood;
	
	@Column(nullable = false)
	private String district;
	
	@Column(nullable = false)
	private String completeAddress;
	

}
