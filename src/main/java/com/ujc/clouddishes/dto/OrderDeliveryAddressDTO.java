package com.ujc.clouddishes.dto;

import lombok.Data;

@Data
public class OrderDeliveryAddressDTO {

    private String province;
	private String district;
	private String neighborhood;
	private String completeAddress;
    private String nickname;

}
