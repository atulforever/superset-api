package com.atul.app.supersetapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atul.app.supersetapi.util.Utilities;

@SpringBootApplication
public class SupersetapiApplication {

	private static final Logger logger = LoggerFactory.getLogger(Utilities.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(SupersetapiApplication.class, args);
		logger.info("Application is running.");
	}
	
}
