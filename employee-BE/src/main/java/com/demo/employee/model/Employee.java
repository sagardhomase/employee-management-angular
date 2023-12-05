package com.demo.employee.model;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name ="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "First Name is Manadtory")
	@Length(min = 3, message = "must be mininum of 3 characters")
	private String firstName;
	
	@NotBlank(message = "Last Name is Manadtory")
	@Length(min = 3, message = "must be mininum of 3 characters")
	private String lastName;
	
	@NotBlank(message = "Department Name is Manadtory")
	@Length(min = 2, message = "must be mininum of 3 characters")
	private String department;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate dob;
	
	@NotNull(message = "Salary must not be empty")
	private Double salary;
	private String manager;
	
	public Employee() {
	
	}

	public Employee(int id, String firstName, String lastName, String department, LocalDate dob, double salary,
			String manager) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.dob = dob;
		this.salary = salary;
		this.manager = manager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
				+ department + ", dob=" + dob + ", salary=" + salary + ", manager=" + manager + "]";
	}
	
	
	
	
	
}
