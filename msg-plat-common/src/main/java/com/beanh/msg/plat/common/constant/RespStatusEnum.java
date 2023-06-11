package com.beanh.msg.plat.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 全局响应状态枚举
 *
 * @author Bean
 * @date 2023/6/11 15:43
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespStatusEnum {

	SUCCESS("00000", "操作成功"),
	FAIL("00001", "操作失败"),

	/**
	 * 客户端
	 */
	CLIENT_BAD_PARAMETERS("A0100", "客户端参数错误"),

	/**
	 * 系统
	 */
	SERVICE_ERROR("B0001", "服务执行异常"),
	RESOURCE_NOT_FOUND("B0404", "资源不存在"),
	;

	/**
	 * 响应状态
	 */
	private final String code;
	/**
	 * 响应编码
	 */
	private final String msg;
}
