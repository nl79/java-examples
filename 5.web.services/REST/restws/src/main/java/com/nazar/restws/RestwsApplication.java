package com.nazar.restws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
// Display the auto configuration for particular packages.
// @EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class RestwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestwsApplication.class, args);
	}
}