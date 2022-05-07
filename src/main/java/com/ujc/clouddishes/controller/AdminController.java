package com.ujc.clouddishes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.clouddishes.model.User;
import com.ujc.clouddishes.service.UserService;

@RestController
@RequestMapping("/api/admin")//url padrao da api
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	//todo code here

	
	@PostMapping("save")//api/admin/save
	public ResponseEntity<?> saveAdmin (@RequestBody User user){
		
		
		if(userService.findByUsername(user.getUsername()).isPresent()) {
			
			return new ResponseEntity<>(HttpStatus.CONFLICT);	
		}

		return new ResponseEntity<>(userService.saveAdmin(user), HttpStatus.CREATED);
	}
	
	@GetMapping("findall")//api/admin/findall
	public ResponseEntity<?> findAllAdmins(){
		
		return new ResponseEntity<>(userService.findAllAdmins(), HttpStatus.OK);
	}
	
	
	
	
}
