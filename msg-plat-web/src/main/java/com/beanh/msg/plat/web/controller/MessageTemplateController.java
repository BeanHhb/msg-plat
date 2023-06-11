package com.beanh.msg.plat.web.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.beanh.msg.plat.support.dao.MessageTemplateDao;
import com.beanh.msg.plat.support.domain.MessageTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bean
 * @date 2023/6/11 13:36
 */
@RestController
@RequestMapping("messageTemplate")
public class MessageTemplateController {

	@Autowired
	private MessageTemplateDao messageTemplateDao;

	/**
	 * test insert
	 */
	@GetMapping("/insert")
	public String insert() {

		MessageTemplate messageTemplate = MessageTemplate.builder()
				.name("test短信")
				.auditStatus(10)
				.flowId("yyyy")
				.msgStatus(10)
				.idType(10)
				.sendChannel(10)
				.templateType(10)
				.msgType(10)
				.expectPushTime("0")
				.msgContent("3333333m")
				.sendAccount(66)
				.creator("yyyyc")
				.updater("yyyyu")
				.team("yyyt")
				.proposer("yyyy22")
				.auditor("yyyyyyz")
				.isDeleted(0)
				.created(Math.toIntExact(DateUtil.currentSeconds()))
				.updated(Math.toIntExact(DateUtil.currentSeconds()))
				.deduplicationTime(1)
				.isNightShield(0)
				.build();

		MessageTemplate info = messageTemplateDao.save(messageTemplate);

		return JSON.toJSONString(info);

	}

	/**
	 * test query
	 */
	@GetMapping("/query")
	public String query() {
		Iterable<MessageTemplate> all = messageTemplateDao.findAll();
		for (MessageTemplate messageTemplate : all) {
			return JSON.toJSONString(messageTemplate);
		}
		return null;
	}
}
