package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/get")
	public ResponseEntity<EmployeeDto> getEmployeeDate(@RequestParam(required = true) Long id) throws Exception {
		EmployeeDto employeeDto = employeeService.getUserInfo(id);
		return new ResponseEntity<>(employeeDto, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto response = employeeService.saveUser(employeeDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
