package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ujc.clouddishes.repository.ClientRepository;

import lombok.Data;

@Data
public class ClientServiceImplementation implements ClientService {

	
	@Autowired
	private ClientRepository clientRepository;
}
