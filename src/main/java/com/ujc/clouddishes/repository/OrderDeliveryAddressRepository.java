package com.ujc.clouddishes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujc.clouddishes.model.OrderDeliveryAddress;

public interface OrderDeliveryAddressRepository extends JpaRepository<OrderDeliveryAddress, Long>  {

}
