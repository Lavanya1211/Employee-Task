package com.employee.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public EmployeeDto getUserInfo(Long id) throws Exception {
		Employee employee = employeeDao.getUserInfo(id);
		EmployeeDto employeeDto = new ModelMapper().map(employee, EmployeeDto.class);
		return employeeDto;
	}

	public EmployeeDto saveUser(EmployeeDto employeeDto) {
		Employee employee = new ModelMapper().map(employeeDto, Employee.class);
		Employee result = employeeDao.saveUser(employee);
		EmployeeDto employeeDtoResult = new ModelMapper().map(result, EmployeeDto.class);
		return employeeDtoResult;
	}
	
}
