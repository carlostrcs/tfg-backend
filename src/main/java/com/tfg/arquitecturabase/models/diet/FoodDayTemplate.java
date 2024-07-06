package com.tfg.arquitecturabase.models.diet;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "foodDayTemplates")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDayTemplate {
	@Id
	private String id;
	private String name;
	private List<Meal> meals;
	private NutritionalInfo nutritionalInfo = new NutritionalInfo();

	 public void addMeal(Meal meal) {
	        meals.add(meal);
	        updateNutritionalInfo();
	 }
	 
	 public void updateNutritionalInfo() {
	        for (Meal meal : meals) {
                for (Food food : meal.getFoods()) {
                	NutritionalInfo adjustedNutritionalInfo = new NutritionalInfo(
                            food.getNutritionalInfo().getProteins() * food.getGrams() / 100,
                            food.getNutritionalInfo().getFats() * food.getGrams() / 100,
                            food.getNutritionalInfo().getCarbs() * food.getGrams() / 100,
                            food.getNutritionalInfo().getCalories() * food.getGrams() / 100
                        );
                        nutritionalInfo.add(adjustedNutritionalInfo);
                }
	        }
	  }
}
