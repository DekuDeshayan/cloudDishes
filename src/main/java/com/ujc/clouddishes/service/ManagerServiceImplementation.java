package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.repository.ManagerRepository;

@Service
public class ManagerServiceImplementation implements ManagerService {

	@Autowired
	private ManagerRepository managerRepository;
	
}
