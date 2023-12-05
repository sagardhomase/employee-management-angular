package com.demo.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employee.model.Employee;
import com.demo.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	public Employee saveEmp(Employee e) {
		LocalDate currentDate = LocalDate.now();
		Integer age = Period.between(e.getDob(), currentDate).getYears();
		Employee emp = null;
		if(age>=18) {
			emp = empRepo.save(e);
		}else {
			throw new RuntimeException("Employee Age is below 18");
		}
		return emp;
	} 
	
	public List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	public Employee getEmployee(Integer id) {
		Optional<Employee> empOptional =empRepo.findById(id);
		if(empOptional.isPresent()) {
			return empOptional.get();
		}
		return null;
	}

	public void deleteEmp(Integer id) {
		empRepo.deleteById(id);
		
	}
	
}
