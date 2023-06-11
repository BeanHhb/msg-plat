package com.beanh.msg.plat.handler.handler;

import cn.hutool.core.collection.CollUtil;
import com.beanh.msg.plat.common.pojo.SmsParam;
import com.beanh.msg.plat.common.pojo.TaskInfo;
import com.beanh.msg.plat.handler.scripts.SmsScript;
import com.beanh.msg.plat.support.dao.SmsRecordDao;
import com.beanh.msg.plat.support.domain.SmsRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Bean
 * @date 2023/5/7 17:06
 */
@Component
public class SmsHandler implements Handler {

	@Autowired
	private SmsRecordDao smsRecordDao;

	@Autowired
	private SmsScript smsScript;

	@Override
	public boolean doHandler(TaskInfo taskInfo) {

		SmsParam smsParam = SmsParam.builder()
				.phones(taskInfo.getReceiver())
				.content(taskInfo.getContent())
				.messageTemplateId(taskInfo.getMessageTemplateId())
				.supplierId(10)
				.supplierName("腾讯云通知类消息渠道").build();
		List<SmsRecord> recordList = smsScript.send(smsParam);

		if (CollUtil.isNotEmpty(recordList)) {
			smsRecordDao.saveAll(recordList);
			return true;
		}

		return false;
	}
}
