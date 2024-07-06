package com.tfg.arquitecturabase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tfg.arquitecturabase.repositories.UserRepository;

@Configuration
public class ApplicationConfig {
	
	@Autowired
	@Qualifier("userRepository")
	UserRepository userRepository;

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
	    {
	        return config.getAuthenticationManager();
	    }

	    @Bean
	    public AuthenticationProvider authenticationProvider()
	    {
	        DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userDetailService());
	        authenticationProvider.setPasswordEncoder(passwordEncoder());
	        return authenticationProvider;
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public UserDetailsService userDetailService() {
	        return email -> userRepository.findByEmail(email)
	        .orElseThrow(()-> new UsernameNotFoundException("User not found"));
	    }
}
