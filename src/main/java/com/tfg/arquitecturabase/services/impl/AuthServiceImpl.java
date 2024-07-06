package com.tfg.arquitecturabase.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import com.tfg.arquitecturabase.exceptions.InvalidCredentialsException;
import com.tfg.arquitecturabase.exceptions.UserAlreadyExistsException;
import com.tfg.arquitecturabase.models.AuthResponse;
import com.tfg.arquitecturabase.models.LoginRequest;
import com.tfg.arquitecturabase.models.RegisterRequest;
import com.tfg.arquitecturabase.models.Role;
import com.tfg.arquitecturabase.models.User;
import com.tfg.arquitecturabase.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service("authServiceImpl")
@RequiredArgsConstructor
public class AuthServiceImpl {

	@Autowired
	@Qualifier("userRepository")
	UserRepository _userRepository;
	
	@Autowired
	@Qualifier("jwtServiceImpl")
	JwtServiceImpl _jwtServiceImpl;
	
	private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
	
	public AuthResponse login(LoginRequest request) {
		try {
		 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		}catch(org.springframework.security.authentication.BadCredentialsException e) {
			throw new InvalidCredentialsException("Login","Invalid credentials",HttpStatus.BAD_REQUEST);
		}
	        UserDetails user = _userRepository.findByEmail(request.getEmail()).orElseThrow();
	        String token= _jwtServiceImpl.getToken(user);
	        return AuthResponse.builder()
	            .token(token)
	            .build();

	}
	
	public AuthResponse register(RegisterRequest request) {
		User user = User.builder()
				.name(request.getName())
				.surname(request.getSurname())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.phoneNumber(request.getPhoneNumber())
				.role(Role.USER).build();
		try {
			_userRepository.save(user);
		}catch (org.springframework.dao.DuplicateKeyException e) {
				throw new UserAlreadyExistsException("Register","User with this email already exists",HttpStatus.CONFLICT);
		}
		
		
		return AuthResponse.builder()
				.token(_jwtServiceImpl.getToken(user))
				.build();
	}
	
	public void deleteAccount(String token) {
        String email = _jwtServiceImpl.getUsernameFromToken(token);
        Optional<User> user = _userRepository.findByEmail(email);
        _userRepository.delete(user.get());
    }
}
