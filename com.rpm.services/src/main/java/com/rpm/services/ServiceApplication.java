package com.rpm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.MongoDbFactory;

/**
 * @author MohanRamu
 *
 */
@SpringBootApplication
public class ServiceApplication {

	@Autowired
	private MongoDbFactory mongoDbFactory;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
