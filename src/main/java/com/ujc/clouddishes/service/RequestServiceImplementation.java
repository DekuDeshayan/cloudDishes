package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ujc.clouddishes.repository.RequestRepository;

import lombok.Data;

@Data
public class RequestServiceImplementation implements RequestService {
	
	@Autowired
	private RequestRepository requestRepository;

}
