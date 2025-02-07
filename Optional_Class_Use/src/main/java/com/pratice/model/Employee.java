package com.pratice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Employee {
	
	@Id
	private Integer id;
	private String name;
	private String address;
	

}
