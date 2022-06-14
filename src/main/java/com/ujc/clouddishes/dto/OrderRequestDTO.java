package com.ujc.clouddishes.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class OrderRequestDTO {

	private Set<MealDTO> cartItems = new HashSet<>();
	private OrderDeliveryAddressDTO address;
	private OrderDTO order;
}
