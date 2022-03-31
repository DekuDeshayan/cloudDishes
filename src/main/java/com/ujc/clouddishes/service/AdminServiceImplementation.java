package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.repository.AdminRepository;


@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
}
