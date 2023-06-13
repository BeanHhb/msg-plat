package com.beanh.msg.plat.api.domain;

import lombok.Data;

/**
 * 发送接口 返回值
 *
 * @author huanghebin
 * @date 2023/6/13 13:52
 */
@Data
public class SendResponse {

	/**
	 * 响应状态
	 */
	private String code;

	/**
	 * 响应编码
	 */
	private String msg;
}
