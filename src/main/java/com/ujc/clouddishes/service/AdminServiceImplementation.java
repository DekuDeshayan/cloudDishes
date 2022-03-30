package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ujc.clouddishes.repository.AdminRepository;

import lombok.Data;

@Data
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
}
