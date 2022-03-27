package com.ujc.clouddishes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujc.clouddishes.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
