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

@Document(collection = "foods")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Food {
	private String name;
	private double grams;
	private NutritionalInfo nutritionalInfo;
}
