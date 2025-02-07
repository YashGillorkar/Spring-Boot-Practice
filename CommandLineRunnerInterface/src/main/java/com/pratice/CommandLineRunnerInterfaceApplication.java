package com.pratice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CommandLineRunnerInterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandLineRunnerInterfaceApplication.class, args);
	}

	@Component
	class StartupRunner implements CommandLineRunner {
		@Override
		public void run(String... args) throws Exception {
			System.out.println("Startup logic executed: Application has started successfully!");
			// Add your custom startup logic here, such as initializing resources or loading
			// data
		}

	}

	// In Spring Boot, the CommandLineRunner interface is used to run code after the
	// application context is fully loaded and before the application starts serving
	// requests.
	// It provides a simple way to execute startup logic.
	// Interface: CommandLineRunner has a single run(String... args) method.
	// Annotation: @Component registers the class as a Spring Bean, so it is
	// automatically detected and run.
	// Arguments: The run method takes command-line arguments passed to the
	// application.

	// loading initial data into a database.
	// Performing initial checks or setup operations.
	// Printing configuration or debugging information.
}
