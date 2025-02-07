package com.pratice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// Configuration for Development Environment
@Configuration
@Profile("dev")
public class DevConfig {

	@Bean
	public String dataSource() {
		return "Development DataSource";
	}
}
