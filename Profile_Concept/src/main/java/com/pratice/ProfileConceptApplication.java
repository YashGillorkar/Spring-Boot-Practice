package com.pratice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfileConceptApplication {

    public static void main(String[] args) {
        // Create a SpringApplication instance
        SpringApplication app = new SpringApplication(ProfileConceptApplication.class);
        
        // Set the profile before running the application
        app.setAdditionalProfiles("dev");
        
        // Run the application
        app.run(args);
    }
}
