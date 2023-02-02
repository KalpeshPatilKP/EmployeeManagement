package com.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.employees.exception.ResourceNotFoundException;
import com.employees.model.Employee;
import com.employees.repository.EmployeeRepository;

@Service
public class EmployeeService {


	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
		
	}
	
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee getEmployeeById(@PathVariable int id) {
        
		return employeeRepository.findById(id)
    			.orElseThrow(()->new ResourceNotFoundException("Employee with this id does not exist : "+id));
	
		
	}
	
	public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employeeDetails) {
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee doesn't exist with id :"+id));
		employee.setName(employeeDetails.getName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setMobNo(employeeDetails.getMobNo());
		employee.setDept(employeeDetails.getDept());
		
		return employeeRepository.save(employee);
		
	}

	
	public void deleteEmployee(@PathVariable int id) {
		employeeRepository.deleteById(id);
		
	}
}
