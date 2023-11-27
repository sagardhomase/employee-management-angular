package com.demo.employee.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employee.model.Employee;
import com.demo.employee.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		Employee e = empService.saveEmp(emp);
		return new ResponseEntity<Employee>(e, HttpStatus.ACCEPTED);
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		Employee e = empService.getEmployee(id);
		if(e == null) {
			throw new RuntimeException("Employee Not Found");
		}
		return e;
	}
	
	@PutMapping("/employees/{id}")
	public  ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@RequestBody Employee emp) {
		Employee e = empService.saveEmp(emp);
		return new ResponseEntity<Employee>(e, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmp(@PathVariable Integer id) {
		empService.deleteEmp(id);
	}
}
