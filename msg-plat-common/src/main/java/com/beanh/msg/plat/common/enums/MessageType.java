package com.beanh.msg.plat.common.enums;

/**
 * 发送的消息类型
 *
 * @author Bean
 * @date 2023/4/22 23:34
 */
public enum MessageType {

	NOTICE(10,"通知类消息"),
	MARKETING(20,"营销类消息"),
	AUTH_CODE(30,"验证码消息");

	MessageType(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	private Integer code;
	private String description;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
