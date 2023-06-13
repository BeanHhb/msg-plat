package com.beanh.msg.plat.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author huanghebin
 * @date 2023/6/13 14:07
 */
@Getter
@AllArgsConstructor
public enum BusinessCode {

	COMMON_SEND("send", "普通发送"),

	RECALL("recall", "撤回消息"),
	;

	private String code;

	private String description;
}
