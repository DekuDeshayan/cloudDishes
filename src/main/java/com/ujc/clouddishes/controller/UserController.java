package com.ujc.clouddishes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.clouddishes.model.User;
import com.ujc.clouddishes.model.enums.Role;
import com.ujc.clouddishes.security.UserPrincipal;
import com.ujc.clouddishes.service.AuthenticationService;
import com.ujc.clouddishes.service.UserService;

@RestController
@RequestMapping("/api/user")//url padrao da api
public class UserController {

	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("login")//api/user/login
	public ResponseEntity<?> signIn(@RequestBody User user){
		//method from authservice for doing login
		return new ResponseEntity<> (authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
	}
	
	@PutMapping("change/{role}")//api/user/change/{role}
	public ResponseEntity<?> changeRole(@PathVariable Role role, @AuthenticationPrincipal UserPrincipal userPrincipal){
		
		userService.changeUserRole(userPrincipal.getUsername(), role);
		
		return ResponseEntity.ok(true);
		
	}
	
	
	
	

}
