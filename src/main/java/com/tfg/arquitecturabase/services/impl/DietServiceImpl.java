package com.tfg.arquitecturabase.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tfg.arquitecturabase.models.diet.Food;
import com.tfg.arquitecturabase.models.diet.FoodDayTemplate;
import com.tfg.arquitecturabase.models.diet.Meal;
import com.tfg.arquitecturabase.models.training.Exercise;
import com.tfg.arquitecturabase.models.training.TrainingTemplate;
import com.tfg.arquitecturabase.repositories.ExercisesRepository;
import com.tfg.arquitecturabase.repositories.FoodDayTemplateRepository;
import com.tfg.arquitecturabase.repositories.FoodRepository;
import com.tfg.arquitecturabase.repositories.MealsRepository;
import com.tfg.arquitecturabase.repositories.TrainingTemplateRepository;

import lombok.RequiredArgsConstructor;

@Service("dietServiceImpl")
@RequiredArgsConstructor
public class DietServiceImpl {

	
	@Autowired
	@Qualifier("mealsRepository")
	MealsRepository _mealsRepository;
	
	@Autowired
	@Qualifier("foodDayTemplateRepository")
	FoodDayTemplateRepository _foodDayTemplateRepository;
	
	@Autowired
	@Qualifier("foodRepository")
	FoodRepository _foodRepository;
	
	public List<FoodDayTemplate> getAllFoodDayTemplates() {
		return _foodDayTemplateRepository.findAll();
	}
	
	public List<Meal> getMealsList() {
		return _mealsRepository.findAll();
	}
	
	public Object saveFoodDayTemplate(FoodDayTemplate foodDayTemplate) {
		foodDayTemplate.updateNutritionalInfo();
		return _foodDayTemplateRepository.save(foodDayTemplate);
	}
	
	public Object saveFood(Food food) {
		return _foodRepository.save(food);
	}
	
	public void deleteFoodDayTemplate(String id) {
		_foodDayTemplateRepository.deleteById(id);
	}
	
	public List<Food> getFoodsList() {
		return _foodRepository.findAll();
	}
	
	public Object saveMeal(Meal meal) {
		meal.updateNutritionalInfo();
		return _mealsRepository.save(meal);
	}
	
	
}
