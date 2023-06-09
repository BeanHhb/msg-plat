package com.beanh.msg.plat.common.domain;

import com.beanh.msg.plat.common.dto.ContentModel;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * 发送任务信息
 *
 * @author Bean
 * @date 2023/5/7 16:14
 */
@Data
@Builder
public class TaskInfo {

	/**
	 * 消息模板Id
	 */
	private long messageTemplateId;

	/**
	 * 业务Id
	 */
	private Long businessId;

	/**
	 * 接收者
	 */
	private Set<String> receiver;

	/**
	 * 发送的Id类型
	 */
	private Integer idType;

	/**
	 * 发送渠道
	 */
	private Integer sendChannel;

	/**
	 * 模板类型
	 */
	private Integer templateType;

	/**
	 * 消息类型
	 */
	private Integer msgType;

	/**
	 * 发送文案模型
	 * message_template表存储的content是JSON(所有内容都会塞进去)
	 * 不同的渠道要发送的内容不一样(比如发push会有img，而短信没有)
	 */
	private ContentModel contentModel;

	/**
	 * 发送账号（邮件下可有多个发送账号、短信可有多个发送账号..）
	 */
	private Integer sendAccount;

	/**
	 * 消息去重时间 单位小时
	 */
	private Integer deduplicationTime;

	/**
	 * 是否夜间屏蔽
	 * 0:不屏蔽
	 * 1：屏蔽
	 */
	private Integer isNightShield;

}
