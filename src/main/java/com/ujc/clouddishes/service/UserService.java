package com.ujc.clouddishes.service;

import java.util.Optional;

import com.ujc.clouddishes.model.User;
import com.ujc.clouddishes.model.enums.Role;

public interface UserService {
	
	void changeUserRole(String username, Role role);
	
	User saveUser(User user);

	Optional<User> findByUsername(String username);


}
