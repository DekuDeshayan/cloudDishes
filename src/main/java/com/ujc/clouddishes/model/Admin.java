package com.ujc.clouddishes.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ujc.clouddishes.model.enums.Gender;

import lombok.Data;

@Data
@Entity
@Table(name="administrator")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 100)
	private String surname;
	
	@Column(nullable = false, length = 9)
	private String phone;
	
	@Enumerated(EnumType.STRING)	
	@Column(nullable = false)
	private Gender gender;
	
	@Column(nullable = false)
	private LocalDateTime createTime;
	
	@OneToOne
	@MapsId
	private User user;
	
	
}
