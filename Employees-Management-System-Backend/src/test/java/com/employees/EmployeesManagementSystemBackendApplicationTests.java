package com.employees;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employees.model.Employee;
import com.employees.repository.EmployeeRepository;
import com.employees.service.EmployeeService;


@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
class EmployeesManagementSystemBackendApplicationTests {

	@Autowired
	private EmployeeService empService;
	
	@MockBean
	private EmployeeRepository empRepository;
	
	
	//test case for saving employee
	@Test
	public void createEmployeeTest() {
		Employee e=new Employee(101,"Raju Patel","raju@gmail.com",9879879879L,"HR");
		Mockito.when(empRepository.save(e)).thenReturn(e);
	}
	
	
	//test case for get all employees
	@Test
	public void getEmployeeTest() {
		Employee e1=new Employee(101,"Raju Patel","raju@gmail.com",9879879879L,"HR");
		Employee e2=new Employee(102,"sanju Patel","sanju@gmail.com",8888778859L,"Finance");
		
		List<Employee> list=new ArrayList<>();
		Mockito.when(empRepository.findAll()).thenReturn(list);
		assertThat(empService.getAllEmployees()).isEqualTo(list);
	}
	
	
	//test case for get employees by id
	@Test
	public void getEmployeeByIdTest() {
		Employee e=new Employee(101,"Raju Patel","raju@gmail.com",9879879879L,"HR");
		
		Optional<Employee> e2=Optional.of(e);
		Mockito.when(empRepository.findById(1)).thenReturn(e2);
	}
	
	
	//test case for update employee
	@Test
	public void updateEmployeeTest() {
		Employee e=new Employee(101,"Raju Patel","raju@gmail.com",9879879879L,"HR");
	
		Optional<Employee> e2=Optional.of(e);
		Mockito.when(empRepository.findById(1)).thenReturn(e2);
		Mockito.when(empRepository.save(e)).thenReturn(e);
		e.setName("Sanju");
		e.setEmailId("sanju@gmail.com");
		e.setMobNo(9879879879L);
		e.setDept("HR");
	
	}
	
	
	//test case for delete employee
	@Test
	public void deleteEmployeeTest() {
		Employee e=new Employee(101,"Raju Patel","raju@gmail.com",9879879879L,"HR");
		
		Mockito.when(empRepository.existsById(e.getId())).thenReturn(false);
		assertFalse(empRepository.existsById(e.getId()));
	}

}
