package com.ujc.clouddishes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ujc.clouddishes.model.enums.Role;
import com.ujc.clouddishes.security.jwt.JwtAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests()
		  .antMatchers("/api/authentication/**").permitAll()//first allowed endpoints for all user roles
		  .antMatchers("/api/restaurant/**").permitAll()//first allowed endpoints for all user roles
		  .antMatchers("/api/meal/**").permitAll()//first allowed endpoints for all user roles
		  .antMatchers("/api/order/**").permitAll()//first allowed endpoints for all user roles
	      .antMatchers("/api/client/sign-up").permitAll()//first allowed endpoints for all user roles
	      .antMatchers("/api/manager/save").hasRole(Role.ADMIN.name()) //then this restricted endpoints will be accessible only if the user has a role called admin
	      .antMatchers("/api/restaurant/save").hasRole(Role.ADMIN.name()) //then this restricted endpoints will be accessible only if the user has a role called admin
	      .antMatchers("/api/receptionist/save").hasRole(Role.MANAGER.name()) //then this restricted endpoints will be accessible only if the user has a role called manager
	      .antMatchers("/api/meal/save").hasRole(Role.MANAGER.name()) //then this restricted endpoints will be accessible only if the user has a role called manager
	      .anyRequest().authenticated();
		
		 http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	
	//why dont we use it as a component, because of scope
	@Bean
	 public JwtAuthorizationFilter jwtAuthorizationFilter () {
		 
		 return new JwtAuthorizationFilter();
	 }
	
	
	
	@Override
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	public AuthenticationManager authenticationManagerBean() throws Exception {
		 
		return super.authenticationManagerBean();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
			
		};
	}
	
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	

}
