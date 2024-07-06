package com.tfg.arquitecturabase.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mongodb.client.model.ReturnDocument;
import com.tfg.arquitecturabase.exceptions.InvalidCredentialsException;
import com.tfg.arquitecturabase.models.AuthResponse;
import com.tfg.arquitecturabase.models.LoginRequest;
import com.tfg.arquitecturabase.models.training.EmptyWorkout;
import com.tfg.arquitecturabase.models.training.Exercise;
import com.tfg.arquitecturabase.models.training.TrainingTemplate;
import com.tfg.arquitecturabase.repositories.ExercisesRepository;
import com.tfg.arquitecturabase.repositories.EmptyWorkoutRepository;
import com.tfg.arquitecturabase.repositories.TrainingTemplateRepository;
import com.tfg.arquitecturabase.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service("TrainingServiceImpl")
@RequiredArgsConstructor
public class TrainingServiceImpl {
	
	@Autowired
	@Qualifier("TrainingTemplateRepository")
	TrainingTemplateRepository _trainingTemplateRepository;
	
	@Autowired
	@Qualifier("exercisesRepository")
	ExercisesRepository _exercisesRepository;
	
	@Autowired
	@Qualifier("emptyWorkoutRepository")
	EmptyWorkoutRepository _emptyWorkoutRepository;
	
	public List<TrainingTemplate> getAllTrainingTemplates() {
		return _trainingTemplateRepository.findAll();
	}
	
	public Object saveTrainingTemplate(TrainingTemplate trainingTemplate) {
		return _trainingTemplateRepository.save(trainingTemplate);
	}
	
	public List<Exercise> getExercisesList() {
		return _exercisesRepository.findAll();
	}
	
	public void deleteTrainingTemplate(String id) {
		_trainingTemplateRepository.deleteById(id);
	}
	
	public Exercise saveCustomExercise(Exercise exercise) {
		return _exercisesRepository.save(exercise);
	}
	
	public Object saveTrainingWorkout(EmptyWorkout trainingWorkout) {
		System.out.println("SERVICE");
		return _emptyWorkoutRepository.save(trainingWorkout);
	}
	
}
