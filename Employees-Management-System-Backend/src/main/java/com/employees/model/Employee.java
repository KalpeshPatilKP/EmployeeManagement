package com.employees.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Emp_Id")
	private int id;
	@Column(name="Emp_FullName")
	private String name;
	@Column(name="Emp_EmailId")
	private String emailId;
	@Column(name="Emp_MobNo")
	private long mobNo;
	@Column(name="Emp_Department")
	private String dept;
	
	
	public Employee(int id, String name, String emailId, long mobNo, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.mobNo = mobNo;
		this.dept = dept;
	}


	public Employee() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public long getMobNo() {
		return mobNo;
	}


	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
	
	
	
}
