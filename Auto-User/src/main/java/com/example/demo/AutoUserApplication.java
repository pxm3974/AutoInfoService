package com.example.demo;


import java.security.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.*;

@RestController
@SpringBootApplication
@EnableResourceServer
@EnableWebSecurity
public class AutoUserApplication extends WebSecurityConfigurerAdapter{
	
	public static void main(String[] args) {
		SpringApplication.run(AutoUserApplication.class, args);
	}
	//This method will be used to check if the user has a valid token to access the resource
	@RequestMapping("/validateUser")
	public Principal user(Principal user) {
			return user;
		}
	
	 @Bean
	 @Override
	 public AuthenticationManager authenticationManagerBean () throws Exception {
		 return super.authenticationManagerBean ();
	 }
	    

	 @Bean
	 @Override 
	 public UserDetailsService userDetailsService () {

		 UserDetails user =User.builder().username("user").password(OAuth2Config
				 .passwordEncoder().encode("secret")). roles("USER").build ();

		 UserDetails userAdmin =User.builder().username("admin").password(OAuth2Config
				 .passwordEncoder().encode("secret")). roles("ADMIN").build ();

		 return new InMemoryUserDetailsManager(user, userAdmin); }
}
