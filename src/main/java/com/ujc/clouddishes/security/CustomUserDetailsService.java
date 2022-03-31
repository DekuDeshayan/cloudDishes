package com.ujc.clouddishes.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ujc.clouddishes.model.User;
import com.ujc.clouddishes.service.UserService;
import com.ujc.clouddishes.utils.SecurityUtils;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
		
		Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
		
		//User Details
		return UserPrincipal.builder()
				.user(user)
				.id(user.getId())
				.username(username)
				.password(user.getPassword())	
				.authorities(authorities)
				.build();
	}
	
	
	 

}
