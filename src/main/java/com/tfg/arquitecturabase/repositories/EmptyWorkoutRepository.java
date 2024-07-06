package com.tfg.arquitecturabase.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tfg.arquitecturabase.models.training.EmptyWorkout;
import com.tfg.arquitecturabase.models.training.Exercise;

@Repository("emptyWorkoutRepository")
public interface EmptyWorkoutRepository extends MongoRepository<EmptyWorkout,String> {

}
