package com.tfg.arquitecturabase.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tfg.arquitecturabase.models.diet.Food;

@Repository("foodRepository")
public interface FoodRepository extends MongoRepository<Food, String> {

}
