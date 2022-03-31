package com.ujc.clouddishes.security.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;



public interface JwtProvider {

	Authentication getAuthentication(HttpServletRequest request);

	boolean isTokenValid(HttpServletRequest request);

}
