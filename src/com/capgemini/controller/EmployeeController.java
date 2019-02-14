package com.capgemini.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Employee;

@RestController
public class EmployeeController {
	
	List<Employee> allEmployee=new ArrayList<Employee>();
	
	public EmployeeController() {
		Employee employee=new Employee();
		employee.setEmpId(100);
		employee.setEmpName("Nisha");
		employee.setEmpSalary(7000);
		allEmployee.add(employee);
	}
	// Different Responses will be produced here --produces
	//@PathVariable means --internally Http.getParameter()
	@RequestMapping(value="/cg/{id}", method=RequestMethod.GET, produces=org.springframework.http.MediaType.APPLICATION_XHTML_XML_VALUE)
	public Employee getEmployeeById(@PathVariable("id") int empId) {
		
		Employee searchResult=null;
		
		for(Employee emp:allEmployee) {
			if(emp.getEmpId()==empId) {
				
				searchResult=emp;
				break;
			}
			
		}
		return searchResult;
	}
	
	@RequestMapping(value="/getempjson/{id}", method=RequestMethod.GET, produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
			public Employee getEmployeeJSON(@PathVariable("id") int empId) {
		
		Employee searchResult=null;
		
		for(Employee emp:allEmployee) {
			if(emp.getEmpId()==empId) {
				
				searchResult=emp;
				break;
			}
			
		}
		return searchResult;
	}
	
	//This two method is to show how we can send the data to backend -in various ways
	@RequestMapping(value="/addEmp",consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	public ResponseEntity<?>addEmployeeInJson(@RequestBody Employee employee){
		
		allEmployee.add(employee);
		System.out.println("Object is added to the collection ::");
		System.out.println("size is :"+allEmployee.size());
		return ResponseEntity.ok().body("Employee Data");
	}
	
	@RequestMapping(value="/addEmpInXML",consumes=org.springframework.http.MediaType.APPLICATION_XML_VALUE,method=RequestMethod.POST)
	public ResponseEntity<?>addEmployeeInXML(@RequestBody Employee employee){
		
		allEmployee.add(employee);
		System.out.println("Object is added to the collection ::");
		System.out.println("size is :"+allEmployee.size());
		return ResponseEntity.ok().body("Employee Data");
	}
	@RequestMapping(value="/deleteemp/{id}", method=RequestMethod.GET)
	public ResponseEntity<?>deleteEmpId(@PathVariable("id") int empId){
		
		Iterator<Employee> it=allEmployee.iterator();
		while(it.hasNext()) {
			Employee e=it.next();
			if(e.getEmpId()==empId) {
				it.remove();
				break;
			}
		}
		return ResponseEntity.ok().body("Employee Deleted");
		
	}
	
	
	
}
