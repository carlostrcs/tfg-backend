package com.tfg.arquitecturabase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.arquitecturabase.models.AuthResponse;
import com.tfg.arquitecturabase.models.LoginRequest;
import com.tfg.arquitecturabase.models.RegisterRequest;
import com.tfg.arquitecturabase.services.impl.AuthServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired
	@Qualifier("authServiceImpl")
	AuthServiceImpl _authService;
	
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody LoginRequest request){
		return _authService.login(request);
	}
	
	@PostMapping("/register")
	public AuthResponse register(@RequestBody RegisterRequest request){
		return _authService.register(request);
//		return ResponseEntity.ok(_authService.register(request));
	}
	
	@DeleteMapping("/deleteAccount")
	public void deleteAccount(HttpServletRequest request){
		
//		if (authToken.startsWith("Bearer ")) {
//            authToken = authToken.substring(7);
//        }
//		System.out.println("TOKEN: " + authToken);
		final String authHeader=request.getHeader(HttpHeaders.AUTHORIZATION);

        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer "))
        {
            String authToken = authHeader.substring(7);
            _authService.deleteAccount(authToken);
        }
		
	}
}
