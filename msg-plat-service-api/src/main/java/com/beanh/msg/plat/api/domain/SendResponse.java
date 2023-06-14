package com.beanh.msg.plat.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发送接口 返回值
 *
 * @author huanghebin
 * @date 2023/6/13 13:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
