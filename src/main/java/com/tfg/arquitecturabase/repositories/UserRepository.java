package com.tfg.arquitecturabase.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tfg.arquitecturabase.models.User;
import java.util.List;


@Repository("userRepository")
public interface UserRepository extends MongoRepository<User,String> {
	Optional<User> findByEmail(String email);
}
