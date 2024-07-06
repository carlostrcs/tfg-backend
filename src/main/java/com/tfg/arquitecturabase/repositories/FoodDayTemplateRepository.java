package com.tfg.arquitecturabase.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tfg.arquitecturabase.models.diet.FoodDayTemplate;
import com.tfg.arquitecturabase.models.training.TrainingTemplate;

@Repository("foodDayTemplateRepository")
public interface FoodDayTemplateRepository extends MongoRepository<FoodDayTemplate,String>{

}
