package com.example.empmanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empmanager.exception.UserNotFoundException;
import com.example.empmanager.model.Employee;
import com.example.empmanager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	} 
	
	public void deleteEmployee(Long id) {
		employeeRepository.deleteEmployeeById(id);
	} 
	
	public Employee findEmployeeById(Long id) {
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User By Id " + id + " Not Found..!"));
	}
}
