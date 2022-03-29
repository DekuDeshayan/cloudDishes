package com.ujc.clouddishes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujc.clouddishes.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
