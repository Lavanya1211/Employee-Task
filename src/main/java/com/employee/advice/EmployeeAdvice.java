package com.employee.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeAdvice {
	
	@ExceptionHandler(value = Exception.class)
	public static ResponseEntity<Map<String, Object>> generateException(Exception e){
		Map<String, Object> response = new HashMap<>();
		response.put("message", e.getMessage());
		response.put("resposeCode", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
