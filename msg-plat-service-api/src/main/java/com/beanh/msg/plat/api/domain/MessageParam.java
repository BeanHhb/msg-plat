package com.beanh.msg.plat.api.domain;

import lombok.Data;

import java.util.Map;

/**
 * 消息参数
 *
 * @author huanghebin
 * @date 2023/6/13 13:59
 */
@Data
public class MessageParam {

	/**
	 * 接收者
	 * 多个用','分隔
	 */
	private String receiver;

	/**
	 * 消息内容中可变部分
	 */
	private Map<String, String> variables;

	/**
	 * 扩展参数
	 */
	private Map<String, String> extra;
}
