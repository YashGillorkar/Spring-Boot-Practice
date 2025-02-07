package com.pratice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// Configuration for Production Environment
@Configuration
@Profile("prod")
public class ProdConfig {

	@Bean
	public String dataSource() {
		return "Production DataSource";
	}
}
