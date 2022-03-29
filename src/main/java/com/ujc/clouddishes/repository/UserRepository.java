package com.ujc.clouddishes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujc.clouddishes.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
