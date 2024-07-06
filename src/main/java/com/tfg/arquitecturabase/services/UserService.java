package com.tfg.arquitecturabase.services;

import java.util.List;

import com.tfg.arquitecturabase.models.User;

public interface UserService {

	public abstract User addUser(User user);
	public abstract User getUserById(String userId);
	public abstract List<User> getAllUsers();
}
