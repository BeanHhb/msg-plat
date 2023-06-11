package com.beanh.msg.plat.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Bean
 * @date 2023/4/16 15:40
 */
@SpringBootApplication(scanBasePackages = {"com.beanh.msg.plat"})
@ComponentScan({"com.beanh.msg.plat.handler", "com.beanh.msg.plat.support"})
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}