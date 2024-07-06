package com.tfg.arquitecturabase.models.diet;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.tfg.arquitecturabase.models.training.Exercise;
import com.tfg.arquitecturabase.models.training.TrainingTemplate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NutritionalInfo {
	private double proteins;
	private double fats;
	private double carbs;
	private double calories;
	
	public void add(NutritionalInfo other) {
        this.proteins += other.proteins;
        this.fats += other.fats;
        this.carbs += other.carbs;
        this.calories += other.calories;
    }

    public void multiplyBy(double factor) {
        this.proteins *= factor;
        this.fats *= factor;
        this.carbs *= factor;
        this.calories *=factor;
    }
}
