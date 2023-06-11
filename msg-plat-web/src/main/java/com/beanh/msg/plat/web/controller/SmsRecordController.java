package com.beanh.msg.plat.web.controller;

import com.beanh.msg.plat.support.dao.SmsRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bean
 * @date 2023/6/11 13:39
 */
@RestController
@RequestMapping("smsRecord")
public class SmsRecordController {

	@Autowired
	private SmsRecordDao smsRecordDao;

	/**
	 * test insert
	 */
	@GetMapping("/insert")
	public String insert(Integer phone) {
		return null;
	}

	/**
	 * test query
	 */
	@GetMapping("/query")
	public String query() {

		return null;
	}
}
