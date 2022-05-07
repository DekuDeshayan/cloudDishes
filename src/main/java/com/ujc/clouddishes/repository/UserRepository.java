package com.ujc.clouddishes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujc.clouddishes.model.User;
import com.ujc.clouddishes.model.enums.Role;

public interface UserRepository extends JpaRepository<User, Long> {
	

	Optional<User> findByUsername (String username);
	
	@Modifying
	@Query("update User set role = :role where username = :username")
	void updateUserRole(@Param("username") String username, @Param("role") Role role);
	
	@Query("SELECT u FROM User u WHERE u.role = :role")
	List<User> findAllClients(@Param("role") Role role);
	
	@Query("SELECT m FROM User m WHERE m.role = :role")
	List<User> findAllManagers(@Param("role") Role role);
	
	@Query("SELECT r FROM User r WHERE r.role = :role")
	List<User> findAllReceptionists(@Param("role") Role role);
	
	@Query("SELECT a FROM User a WHERE a.role = :role")
	List<User> findAllAdmins(@Param("role") Role role);	
	

}
