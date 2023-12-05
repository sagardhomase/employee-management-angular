package com.demo.employee.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintVoilation(ConstraintViolationException ex){
		List<String> errors = new ArrayList<String>();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": "
					+ violation.getMessage());
		}

		EmployeeException apiError = new EmployeeException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleRuntime(RuntimeException ex){
		List<String> errors = new ArrayList<String>();
		
		EmployeeException apiError = new EmployeeException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
}
