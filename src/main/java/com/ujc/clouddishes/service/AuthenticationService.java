package com.ujc.clouddishes.service;

import com.ujc.clouddishes.model.User;

public interface AuthenticationService {

	User signInAndReturnJWT(User signInRequest);

}
