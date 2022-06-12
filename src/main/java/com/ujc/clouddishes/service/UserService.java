package com.ujc.clouddishes.service;

import java.util.List;
import java.util.Optional;

import com.ujc.clouddishes.model.User;
import com.ujc.clouddishes.model.enums.Role;
import com.ujc.clouddishes.repository.projections.ManagersNotLinkedToRestaurants;

public interface UserService {

	User saveClient(User user);
	
	User saveManager(User user);
	
	User saveReceptionist (User user);
	
	User saveAdmin(User user);
	
	List<User> findAllAdmins();
	
	List<User> findAllReceptionists();
	
	List<User> findAllManagers();
	
	List<User> findAllClients();
	
	Optional<User> findByUsername(String username);
	
	void changeUserRole(String username, Role role);

	List<ManagersNotLinkedToRestaurants> findManagersNotLinkedToRestaurants();

	
	
	


}
