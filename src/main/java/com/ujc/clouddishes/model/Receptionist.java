package com.ujc.clouddishes.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.ujc.clouddishes.model.enums.Gender;

import lombok.Data;

@Data
@Entity
public class Receptionist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 100)
	private String surname;
	
	@Column(nullable = false, length = 9)	
	private Integer phone;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;
	
	@Column(nullable = false)
	private LocalDate createTime;

	@OneToOne(mappedBy = "recepcionist", cascade = CascadeType.ALL)
	private User user;//o user sera mapeado pelo recepcionista
}
