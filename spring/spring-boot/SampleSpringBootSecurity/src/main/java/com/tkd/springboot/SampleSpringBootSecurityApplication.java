package com.tkd.springboot;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tarun.das
 *
 */
@SpringBootApplication
public class SampleSpringBootSecurityApplication {
	
	private static final Logger LOGGER = Logger.getLogger(SampleSpringBootSecurityApplication.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.debug("Spring Boot Security Applicaton is now going to start");
		SpringApplication.run(SampleSpringBootSecurityApplication.class, args);
	}
}
