package com.beanh.msg.plat.common.enums;

/**
 * sms状态
 *
 * @author Bean
 * @date 2023/4/22 23:36
 */
public enum SmsStatus {

	SEND_SUCCESS(10,"调用渠道接口发送成功"),
	RECEIVE_SUCCESS(20,"用户收到短信(收到渠道短信回执，状态成功)"),
	RECEIVE_FAIL(30, "用户收不到短信(收到渠道短信回执，状态失败)");

	SmsStatus(Integer code, String description) {
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
