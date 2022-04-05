package com.ujc.clouddishes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.clouddishes.model.User;
import com.ujc.clouddishes.service.UserService;

@RestController
@RequestMapping("/api/manager/")//url padrao da api
public class ManagerController {
	
	@Autowired
	private UserService userService;
	
	/*
	 * Método de cadastro de Manager
	 */
	@PostMapping("save")//api/manager/save
	public ResponseEntity<?> saveManager (@RequestBody User user){
		
		
		if(userService.findByUsername(user.getUsername()).isPresent()) {
			
			return new ResponseEntity<>(HttpStatus.CONFLICT);	
		}
		
		return new ResponseEntity<>(userService.saveManager(user), HttpStatus.CREATED);
	}

}
