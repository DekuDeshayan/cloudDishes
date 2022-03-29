package com.ujc.clouddishes.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ujc.clouddishes.model.enums.Gender;
import com.ujc.clouddishes.model.enums.Role;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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
	
	//mapeamentos da chave estrangeira User_ID nas entidades abaixo instanciadas

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Client client;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Admin admin;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Manager manager;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Receptionist receptionist;
	
	
	
	
}
