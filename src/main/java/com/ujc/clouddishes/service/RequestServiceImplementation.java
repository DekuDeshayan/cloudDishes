package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.repository.RequestRepository;

@Service
public class RequestServiceImplementation implements RequestService {
	
	@Autowired
	private RequestRepository requestRepository;

}
