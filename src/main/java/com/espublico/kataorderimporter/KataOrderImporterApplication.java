package com.espublico.kataorderimporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * The main class for the KataOrderImporter application.
 * This class contains the main method to start the Spring Boot application.
 * 
 * @author Andreu Aguilar
 * @version 1.0
 * @since 2024-01-22
 */
@SpringBootApplication
public class KataOrderImporterApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(KataOrderImporterApplication.class, args);

		// Stop Spring Boot application
		System.exit(SpringApplication.exit(context, () -> 0));
	}

}
