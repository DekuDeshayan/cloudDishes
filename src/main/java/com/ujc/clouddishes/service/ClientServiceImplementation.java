package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.repository.ClientRepository;

@Service
public class ClientServiceImplementation implements ClientService {

	
	@Autowired
	private ClientRepository clientRepository;
}
