package com.beanh.msg.plat.web;

import com.beanh.msg.plat.common.pojo.SmsParam;
import com.beanh.msg.plat.handler.scripts.TencentSmsScript;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Bean
 * @date 2023/4/16 15:40
 */
@SpringBootApplication
@ComponentScan("com.beanh.msg.plat.handler")
@RestController
public class WebApplication {

	@Autowired
	private TencentSmsScript tencentSmsScript;

	private final Logger logger = LoggerFactory.getLogger(WebApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		SmsParam smsParam = SmsParam.builder()
				.phones(new HashSet<>(Arrays.asList("13427008427")))
				.content("3333")
				.build();
		return tencentSmsScript.send(smsParam);
	}
}