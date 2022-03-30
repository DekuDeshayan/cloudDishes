package com.ujc.clouddishes.service;



import com.ujc.clouddishes.model.enums.Role;

public interface UserService {
	
	
	
	void changeUserRole(String username, Role role);
	

}
