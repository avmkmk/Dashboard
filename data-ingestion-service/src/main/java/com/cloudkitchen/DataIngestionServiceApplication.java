package com.cloudkitchen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Main entry point for the Data Ingestion Service application.
 * This class uses Spring Boot's `@SpringBootApplication` annotation,
 * which is a convenience annotation that adds:
 * - `@Configuration`: Tags the class as a source of bean definitions for the application context.
 * - `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings,
 *   other beans, and various property settings. For example, if `spring-webmvc` is on the classpath,
 *   this annotation flags the application as a web application and activates key behaviors such as
 *   setting up a `DispatcherServlet`.
 * - `@ComponentScan`: Tells Spring to look for other components, configurations, and services in the
 *   `com.cloudkitchen` package, allowing it to find and register controllers, services, and repositories.
 */
@SpringBootApplication
public class DataIngestionServiceApplication {

	/**
	 * The main method that serves as the entry point for the Spring Boot application.
	 * It uses `SpringApplication.run()` to bootstrap and launch the application.
	 * @param args Command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DataIngestionServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner createSchema(JdbcTemplate jdbcTemplate) {
		return args -> {
			jdbcTemplate.execute("CREATE SCHEMA IF NOT EXISTS raw_data_schema");
		};
	}
}
