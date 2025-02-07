package com.pratice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.model.Employee;
import com.pratice.repository.EmployeeRepo;

@RestController
public class Controller {

	@Autowired
	EmployeeRepo employeeRepo;

	@GetMapping("/getall")
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	@GetMapping("/id/{id}")
	public Employee getById(@PathVariable Integer id) {
		
//		return employeeRepo.findById(id).orElse(null);

		Boolean status = employeeRepo.findById(id).isPresent();
		if (status) {
			return employeeRepo.findById(id).get();
		}
		return null;
	}
}
