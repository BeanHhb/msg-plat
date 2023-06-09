package com.beanh.msg.plat.web.controller;

import com.beanh.msg.plat.common.domain.TaskInfo;
import com.beanh.msg.plat.common.vo.BasicResultVO;
import com.beanh.msg.plat.handler.handler.SmsHandler;
import com.beanh.msg.plat.web.WebApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashSet;

/**
 * @author Bean
 * @date 2023/5/7 17:11
 */
@RestController
@RequestMapping("send")
public class SendController {

	private final Logger logger = LoggerFactory.getLogger(WebApplication.class);

	@Autowired
	private SmsHandler smsHandler;

	/**
	 * 发送短信
	 *
	 * @param phone
	 * @param content
	 * @param messageTemplateId
	 * @return
	 */
	@GetMapping("/sendSms")
	public BasicResultVO<Void> sendSms(@RequestParam String phone, @RequestParam String content, @RequestParam Long messageTemplateId) {
//		TaskInfo taskInfo = TaskInfo.builder()
//				.receiver(new HashSet<>(Collections.singletonList(phone)))
//				.contentModel(content)
//				.messageTemplateId(messageTemplateId)
//				.build();
//		if (smsHandler.doHandler(taskInfo)) {
//			return BasicResultVO.success("发送信息成功");
//		}
		return BasicResultVO.fail();
	}
}
