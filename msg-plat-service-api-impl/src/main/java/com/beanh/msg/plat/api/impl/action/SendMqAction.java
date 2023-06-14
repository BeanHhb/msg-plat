package com.beanh.msg.plat.api.impl.action;

import com.beanh.msg.plat.api.impl.domain.SendTaskModel;
import com.beanh.msg.plat.support.pipeline.BusinessProcess;
import com.beanh.msg.plat.support.pipeline.ProcessContext;
import com.beanh.msg.plat.support.pipeline.ProcessModel;

/**
 * 发送Mq消息
 * @author huanghebin
 * @date 2023/6/13 16:44
 */
public class SendMqAction implements BusinessProcess {

	@Override
	public void process(ProcessContext context) {
		SendTaskModel sendTaskModel = (SendTaskModel) context.getProcessModel();
		// todo 接入kafka

	}
}
