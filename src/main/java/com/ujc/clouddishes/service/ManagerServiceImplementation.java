package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ujc.clouddishes.repository.ManagerRepository;

import lombok.Data;

@Data
public class ManagerServiceImplementation implements ManagerService {

	@Autowired
	private ManagerRepository managerRepository;
	
}
