package com.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.exception.ResourceNotFoundException;
import com.employees.model.Employee;
import com.employees.repository.EmployeeRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

	@Autowired
	public EmployeeRepository employeeRepository;
	
	
	//get all employees details
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
		
	}
	
	
	//save employee details
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
		
	}
	
	
	//get employee by id
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee doesn't exist with id :"+id));
	}
	
	
	//update employee by id
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employeeDetails) {
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee doesn't exist with id :"+id));
		employee.setName(employeeDetails.getName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setMobNo(employeeDetails.getMobNo());
		employee.setDept(employeeDetails.getDept());
		
		Employee updateEmployee=employeeRepository.save(employee);
		return updateEmployee;
	}
	

	
	
	//delete employee by id
	@DeleteMapping("/employees/{id}")
	public void deleteEmployeeById(@PathVariable int id) {
		employeeRepository.deleteById(id);
		
	}
	
}
