package com.ujc.clouddishes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.clouddishes.model.User;
import com.ujc.clouddishes.service.AuthenticationService;

@RestController
@RequestMapping("/api/authentication/")//url padrao da api
public class AuthenticationController {
	
	/*
	 * Injectando os servicos de autenticacao e utilizadores
	 */
	
	@Autowired
	private AuthenticationService authenticationService;
	
	/*
	 * Método de login de utilizadores
	 */
	
	@PostMapping("login")//api/authentication/login
	public ResponseEntity<?> signIn(@RequestBody User user){
		
		//metodo do AuthenticationService para efetuar login...
		return new ResponseEntity<> (authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
	}
	
	
	
	
	
	

}
