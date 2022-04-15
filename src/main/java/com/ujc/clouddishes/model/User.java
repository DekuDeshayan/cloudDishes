package com.ujc.clouddishes.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ujc.clouddishes.model.enums.Gender;
import com.ujc.clouddishes.model.enums.Role;

import lombok.Data;

@Data
@Entity
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(nullable = false, length = 100)
	private String first_name;
	
	@Column(nullable = false, length = 100)
	private String surname;
	
	@Column(nullable = true, unique = true, length = 100)
	private String email;
	
	@Column(nullable = false, length = 100, unique = true)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false)
	private LocalDateTime createTime;
	
	@Enumerated(EnumType.STRING)	
	@Column(nullable = false)
	private Gender gender;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	/*
		@OneToMany(mappedBy = "user", fetch =  FetchType.LAZY)
		private Set<Order> order;
		
		@OneToMany(mappedBy = "user", fetch =  FetchType.LAZY)
		private Set<Reservation> reservation;
	*/
	
	@Transient
	private String token;
	
	
	
}
