package com.beanh.msg.plat.api.impl.domain;

import com.beanh.msg.plat.api.domain.MessageParam;
import com.beanh.msg.plat.common.domain.TaskInfo;
import com.beanh.msg.plat.support.pipeline.ProcessModel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 发送消息任务模型
 *
 * @author huanghebin
 * @date 2023/6/13 16:46
 */
@Data
@Builder
public class SendTaskModel implements ProcessModel {

	/**
	 * 消息模板Id
	 */
	private Long messageTemplateId;

	/**
	 * 请求参数
	 */
	private List<MessageParam> messageParamList;

	/**
	 * 发送任务的信息
	 */
	private List<TaskInfo> taskInfo;
}
