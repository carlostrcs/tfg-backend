package com.tfg.arquitecturabase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.arquitecturabase.models.AuthResponse;
import com.tfg.arquitecturabase.models.LoginRequest;
import com.tfg.arquitecturabase.models.RegisterRequest;
import com.tfg.arquitecturabase.models.training.EmptyWorkout;
import com.tfg.arquitecturabase.models.training.Exercise;
import com.tfg.arquitecturabase.models.training.TrainingTemplate;
import com.tfg.arquitecturabase.services.impl.AuthServiceImpl;
import com.tfg.arquitecturabase.services.impl.TrainingServiceImpl;

@RestController
@RequestMapping("/training")
@CrossOrigin(origins = "http://localhost:4200")
public class TrainingController {
	
	@Autowired
	@Qualifier("TrainingServiceImpl")
	TrainingServiceImpl _trainingService;
	
	@GetMapping("/getAllTrainingTemplates")
	public List<TrainingTemplate> getAllTrainingTemplates(){
		return _trainingService.getAllTrainingTemplates();
	}
	
	@PostMapping("/saveTrainingTemplate")
	public Object saveTrainingTemplate(@RequestBody TrainingTemplate trainingTemplate){
		return _trainingService.saveTrainingTemplate(trainingTemplate);
	}
	
	@GetMapping("/getExercisesList")
	public List<Exercise> getExercisesList(){
		return _trainingService.getExercisesList();
	}
	
	@DeleteMapping("/deleteTrainingTemplate/{id}")
	public void deleteFoodDayTemplate(@PathVariable String id) {
		 _trainingService.deleteTrainingTemplate(id);
	}
	
	@PostMapping("/saveCustomExercise")
	public Exercise saveCustomExercise(@RequestBody Exercise customExercise){
		return _trainingService.saveCustomExercise(customExercise);
	}
	
	@PostMapping("/saveTrainingWorkout")
	public Object saveTrainingWorkout(@RequestBody EmptyWorkout trainingWorkout){
		return _trainingService.saveTrainingWorkout(trainingWorkout);
	}
	
	
	
}
