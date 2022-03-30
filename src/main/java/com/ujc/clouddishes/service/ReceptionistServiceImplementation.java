package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ujc.clouddishes.repository.ReceptionistRepository;

import lombok.Data;

@Data
public class ReceptionistServiceImplementation implements ReceptionistService{

	@Autowired
	private ReceptionistRepository receptionistRepository;
}
