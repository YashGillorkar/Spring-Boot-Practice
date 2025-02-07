package com.pratice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratice.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	
}
