package com.employee.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.model.Employee;
import com.employee.repo.EmployeeRepository;

@Component
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee getUserInfo(Long id) throws Exception {
		if(id==null) {
			throw new Exception("Kindly pass the id value");
		}
		Optional<Employee> result = employeeRepository.findById(id);
		Employee employee = result.get();
		return employee;
	}

	public Employee saveUser(Employee employee) {
		Employee result = employeeRepository.save(employee);
		return result;
	}
	
}
