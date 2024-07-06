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

import com.tfg.arquitecturabase.models.diet.Food;
import com.tfg.arquitecturabase.models.diet.FoodDayTemplate;
import com.tfg.arquitecturabase.models.diet.Meal;
import com.tfg.arquitecturabase.models.training.Exercise;
import com.tfg.arquitecturabase.models.training.TrainingTemplate;
import com.tfg.arquitecturabase.services.impl.DietServiceImpl;
import com.tfg.arquitecturabase.services.impl.TrainingServiceImpl;

@RestController
@RequestMapping("/diet")
@CrossOrigin(origins = "http://localhost:4200")
public class DietController {


	@Autowired
	@Qualifier("dietServiceImpl")
	DietServiceImpl _dietService;
	
	@GetMapping("/getAllFoodDayTemplates")
	public List<FoodDayTemplate> getAllFoodDayTemplates(){
		return _dietService.getAllFoodDayTemplates();
	}
	
	@GetMapping("/getMealsList")
	public List<Meal> getMealsList(){
		return _dietService.getMealsList();
	}
	
	@PostMapping("/saveFoodDayTemplate")
	public Object saveFoodDayTemplate(@RequestBody FoodDayTemplate foodDayTemplate){
		return _dietService.saveFoodDayTemplate(foodDayTemplate);
	}
	
	@PostMapping("/saveFood")
	public Object saveFood(@RequestBody Food food){
		return _dietService.saveFood(food);
	}
	
	@DeleteMapping("/deleteFoodDayTemplate/{id}")
	public void deleteFoodDayTemplate(@PathVariable String id) {
		 _dietService.deleteFoodDayTemplate(id);
	}
	
	@GetMapping("/getFoodsList")
	public List<Food> getFoodsList(){
		return _dietService.getFoodsList();
	}
	
	@PostMapping("/saveMeal")
	public Object saveMeal(@RequestBody Meal meal){
		return _dietService.saveMeal(meal);
	}
}
