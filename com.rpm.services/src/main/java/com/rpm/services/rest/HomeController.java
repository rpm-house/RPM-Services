package com.rpm.services.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = "/")
	public String getRoot() {
		logger.debug("getRoot");
		return "hai";
	}
	@GetMapping(value = "/hello")
	public String sayHello() {
		logger.debug("sayHello");
		return "hello!";
	}
}
