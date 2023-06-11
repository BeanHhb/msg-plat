package com.beanh.msg.plat.handler.scripts;

import com.beanh.msg.plat.common.pojo.SmsParam;
import com.beanh.msg.plat.support.domain.SmsRecord;

import java.util.List;

/**
 * @author Bean
 * @date 2023/5/7 16:43
 */
public interface SmsScript {

	/**
	 * @param smsParam 发送短信参数
	 * @return 渠道商接口返回值
	 */
	List<SmsRecord> send(SmsParam smsParam);
}
