package com.beanh.msg.plat.api.impl.service;

import com.beanh.msg.plat.api.domain.BatchSendRequest;
import com.beanh.msg.plat.api.domain.SendRequest;
import com.beanh.msg.plat.api.domain.SendResponse;
import com.beanh.msg.plat.api.impl.domain.SendTaskModel;
import com.beanh.msg.plat.api.service.SendService;
import com.beanh.msg.plat.common.vo.BasicResultVO;
import com.beanh.msg.plat.support.pipeline.ProcessContext;
import com.beanh.msg.plat.support.pipeline.ProcessController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 发送接口
 *
 * @author huanghebin
 * @date 2023/6/13 14:16
 */
public class SendServiceImpl implements SendService {

	@Autowired
	private ProcessController processController;

	/**
	 * 单文案发送
	 *
	 * @param sendRequest
	 * @return
	 */
	@Override
	public SendResponse send(SendRequest sendRequest) {
		SendTaskModel sendTaskModel = SendTaskModel.builder()
				.messageTemplateId(sendRequest.getMessageTemplateId())
				.messageParamList(Arrays.asList(sendRequest.getMessageParam()))
				.build();
		ProcessContext context = ProcessContext.builder()
				.code(sendRequest.getCode())
				.processModel(sendTaskModel)
				.needBreak(false)
				.response(BasicResultVO.success())
				.build();

		ProcessContext process = processController.process(context);
		return new SendResponse(process.getResponse().getCode(), process.getResponse().getMsg());
	}

	/**
	 * 多文案发送
	 *
	 * @param batchSendRequest
	 * @return
	 */
	@Override
	public SendResponse batchSend(BatchSendRequest batchSendRequest) {
		SendTaskModel sendTaskModel = SendTaskModel.builder()
				.messageTemplateId(batchSendRequest.getMessageTemplateId())
				.messageParamList(batchSendRequest.getMessageParamList())
				.build();

		ProcessContext context = ProcessContext.builder()
				.code(batchSendRequest.getCode())
				.processModel(sendTaskModel)
				.needBreak(false)
				.response(BasicResultVO.success())
				.build();

		ProcessContext process = processController.process(context);
		return new SendResponse(process.getResponse().getCode(), process.getResponse().getMsg());
	}
}
