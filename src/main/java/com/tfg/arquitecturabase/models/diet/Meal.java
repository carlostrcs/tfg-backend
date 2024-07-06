package com.tfg.arquitecturabase.models.diet;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;
import com.tfg.arquitecturabase.models.training.Exercise;
import com.tfg.arquitecturabase.models.training.TrainingTemplate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "meals")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
	@NonNull
	@Indexed(unique = true)
	private String name;
	private List<Food> foods;
	private NutritionalInfo nutritionalInfo;
	
	public void addFood(Food food) {
        foods.add(food);
    }
	
	public void updateNutritionalInfo() {
        nutritionalInfo = new NutritionalInfo();
        for (Food food : foods) {
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
