package com.ujc.clouddishes.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.model.User;
import com.ujc.clouddishes.model.enums.Role;
import com.ujc.clouddishes.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	//Injecao de dependencias
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public User saveUser(User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.USER);
		user.setCreateTime(LocalDateTime.now());
		
		return userRepository.save(user);
		
	}

	@Override
	public Optional<User> findByUsername(String username) {
		
		return userRepository.findByUsername(username);
		
	}
	
	
	@Override
	@Transactional // Anotacao para consultas que modificam a base de dados: update, deletes
	public void changeUserRole(String username, Role role) {
		
		userRepository.updateUserRole(username, role);
		
	}

	
	
	

}
