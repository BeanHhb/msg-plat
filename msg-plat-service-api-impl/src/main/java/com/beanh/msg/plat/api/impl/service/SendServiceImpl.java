package com.beanh.msg.plat.api.impl.service;

import com.beanh.msg.plat.api.domain.BatchSendRequest;
import com.beanh.msg.plat.api.domain.SendRequest;
import com.beanh.msg.plat.api.domain.SendResponse;
import com.beanh.msg.plat.api.service.SendService;

/**
 * 发送接口
 *
 * @author huanghebin
 * @date 2023/6/13 14:16
 */
public class SendServiceImpl implements SendService {
	/**
	 * 单文案发送
	 *
	 * @param sendRequest
	 * @return
	 */
	@Override
	public SendResponse send(SendRequest sendRequest) {
		return null;
	}

	/**
	 * 多文案发送
	 *
	 * @param batchSendRequest
	 * @return
	 */
	@Override
	public SendResponse batchSend(BatchSendRequest batchSendRequest) {
		return null;
	}
}
