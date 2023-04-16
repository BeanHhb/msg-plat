package com.beanh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bean
 * @date 2023/4/16 15:40
 */
@SpringBootApplication
@RestController
public class WebApplication {

	private final Logger logger = LoggerFactory.getLogger(WebApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.info("info log for msg-plat");
		return String.format("Hello %s!", name);
	}
}