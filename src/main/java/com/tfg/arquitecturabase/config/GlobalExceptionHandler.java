package com.tfg.arquitecturabase.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tfg.arquitecturabase.exceptions.InvalidCredentialsException;
import com.tfg.arquitecturabase.exceptions.UserAlreadyExistsException;
import com.tfg.arquitecturabase.models.ApiErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(
    		UserAlreadyExistsException ex,
    		HttpServletRequest request) {
    	ApiErrorResponse response = new ApiErrorResponse(ex.getErrorMessage(), ex.getErrorCode());
        return new ResponseEntity<ApiErrorResponse>(response, ex.getHttpStatus());
    }
    
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<?> handleInvalidCredentialsException(
    		InvalidCredentialsException ex,
    		HttpServletRequest request) {
    	ApiErrorResponse response = new ApiErrorResponse(ex.getErrorMessage(), ex.getErrorCode());
        return new ResponseEntity<ApiErrorResponse>(response, ex.getHttpStatus());
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleDefaultException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
}