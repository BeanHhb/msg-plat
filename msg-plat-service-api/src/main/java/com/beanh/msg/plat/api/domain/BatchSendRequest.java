package com.beanh.msg.plat.api.domain;

import lombok.Data;

import java.util.List;

/**
 * 发送接口 参数
 * 批量
 *
 * @author huanghebin
 * @date 2023/6/13 14:02
 */
@Data
public class BatchSendRequest {

	/**
	 * 执行业务类型
	 * 必传,参考 BusinessCode枚举
	 */
	private String code;

	/**
	 * 消息模板Id
	 * 必传
	 */
	private Long messageTemplateId;

	/**
	 * 消息相关的参数
	 * 必传
	 */
	private List<MessageParam> messageParamList;
}
