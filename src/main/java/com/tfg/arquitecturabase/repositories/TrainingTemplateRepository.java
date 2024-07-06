package com.tfg.arquitecturabase.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tfg.arquitecturabase.models.User;
import com.tfg.arquitecturabase.models.training.TrainingTemplate;

@Repository("TrainingTemplateRepository")
public interface TrainingTemplateRepository extends MongoRepository<TrainingTemplate,String> {

}
