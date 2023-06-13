package com.beanh.msg.plat.api.service;

import com.beanh.msg.plat.api.domain.BatchSendRequest;
import com.beanh.msg.plat.api.domain.SendRequest;
import com.beanh.msg.plat.api.domain.SendResponse;

/**
 * 发送接口
 *
 * @author huanghebin
 * @date 2023/6/13 11:39
 */
public interface SendService {

	/**
	 * 单文案 发送
	 *
	 * @param sendRequest
	 * @return
	 */
	SendResponse send(SendRequest sendRequest);

	/**
	 * 多文案 发送
	 *
	 * @param batchSendRequest
	 * @return
	 */
	SendResponse batchSend(BatchSendRequest batchSendRequest);
}
