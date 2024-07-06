package com.tfg.arquitecturabase.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tfg.arquitecturabase.models.User;
import com.tfg.arquitecturabase.repositories.UserRepository;
import com.tfg.arquitecturabase.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository _userRepository;

	@Override
	public User addUser(User user) {
//		user.setId("1");
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		System.out.println("Backend Service Password: "+hashedPassword);
		user.setPassword(hashedPassword);
		return _userRepository.save(user);
	}

	@Override
	public User getUserById(String userId) {
		return _userRepository.findById(userId).get();
	}

	@Override
	public List<User> getAllUsers() {
		return _userRepository.findAll();
	}
	
	
}
