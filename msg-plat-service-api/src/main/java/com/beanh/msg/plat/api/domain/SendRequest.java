package com.beanh.msg.plat.api.domain;

import lombok.Data;

/**
 * 发送接口 参数
 *
 * @author huanghebin
 * @date 2023/6/13 13:56
 */
@Data
public class SendRequest {

	/**
	 * 执行业务类型
	 */
	private String code;

	/**
	 * 消息模板Id
	 */
	private Long messageTemplateId;

	/**
	 * 消息相关参数
	 */
	private MessageParam messageParam;
}
