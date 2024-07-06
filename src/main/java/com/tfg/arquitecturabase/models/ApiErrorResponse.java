package com.tfg.arquitecturabase.models;

import lombok.Data;

@Data
public class ApiErrorResponse {
	private final String description;
	private final String error;
}
