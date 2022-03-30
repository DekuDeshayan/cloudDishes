package com.ujc.clouddishes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ujc.clouddishes.model.enums.Role;
import com.ujc.clouddishes.repository.UserRepository;

import lombok.Data;
@Data
public class UserServiceImplementation implements UserService {

	//Dependecy Injection
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void changeUserRole(String username, Role role) {
		
		userRepository.updateUserRole(username, role);
		
	}
	
	
	
	

}
