package com.beanh.msg.plat.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Bean
 * @date 2023/4/16 15:40
 */
@SpringBootApplication
@EnableJpaRepositories("com.beanh.msg.plat.support")
@EntityScan("com.beanh.msg.plat.support")
@ComponentScan({"com.beanh.msg.plat.web", "com.beanh.msg.plat.handler", "com.beanh.msg.plat.support"})
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}