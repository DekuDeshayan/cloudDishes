package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.repository.ReceptionistRepository;

@Service
public class ReceptionistServiceImplementation implements ReceptionistService{

	@Autowired
	private ReceptionistRepository receptionistRepository;
}
