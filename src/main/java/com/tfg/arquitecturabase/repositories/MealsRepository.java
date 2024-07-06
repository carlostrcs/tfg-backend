package com.tfg.arquitecturabase.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tfg.arquitecturabase.models.diet.Meal;
import com.tfg.arquitecturabase.models.training.Exercise;

@Repository("mealsRepository")
public interface MealsRepository extends MongoRepository<Meal,String> {

}
