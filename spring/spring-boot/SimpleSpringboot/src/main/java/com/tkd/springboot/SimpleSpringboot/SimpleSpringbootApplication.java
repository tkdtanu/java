package com.tkd.springboot.SimpleSpringboot;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



/**
 * @author TKD
 *
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages={"com.tkd.springboot"})
public class SimpleSpringbootApplication {
	
	private static final Logger LOGGER = Logger.getLogger(SimpleSpringbootApplication.class);

	public static void main(String[] args) {
		LOGGER.debug("Spring Boot Applicaton is now going to start");
		SpringApplication.run(SimpleSpringbootApplication.class, args);
	}
}
