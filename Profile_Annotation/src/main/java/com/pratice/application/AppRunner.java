package com.pratice.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

	@Autowired
	private String dataSource;

	@Override
	public void run(String... args) {
		System.out.println("Using DataSource: " + dataSource);
	}
}
