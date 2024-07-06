package com.tfg.arquitecturabase.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tfg.arquitecturabase.models.training.Exercise;
import com.tfg.arquitecturabase.models.training.TrainingTemplate;

@Repository("exercisesRepository")
public interface ExercisesRepository extends MongoRepository<Exercise,String> {


}
