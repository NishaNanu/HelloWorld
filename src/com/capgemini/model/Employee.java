package com.capgemini.model;

import javax.xml.bind.annotation.XmlRootElement;

//Simple DTO object
@XmlRootElement
public class Employee {
	
	private int empId;
	private String empName;
	private float empSalary;
	
	public Employee() {
		
	}
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	
	

}
