package com.beanh.msg.plat.api.impl.action;

import cn.hutool.core.collection.CollUtil;
import com.beanh.msg.plat.api.domain.MessageParam;
import com.beanh.msg.plat.api.impl.domain.SendTaskModel;
import com.beanh.msg.plat.common.enums.RespStatusEnum;
import com.beanh.msg.plat.common.vo.BasicResultVO;
import com.beanh.msg.plat.support.pipeline.BusinessProcess;
import com.beanh.msg.plat.support.pipeline.ProcessContext;

import java.util.List;

/**
 * 前置参数校验
 *
 * @author huanghebin
 * @date 2023/6/13 16:43
 */
public class PreParamAction implements BusinessProcess {

	@Override
	public void process(ProcessContext context) {
		SendTaskModel sendTaskModel = (SendTaskModel) context.getProcessModel();
		Long messageTemplateId = sendTaskModel.getMessageTemplateId();
		List<MessageParam> messageParamList = sendTaskModel.getMessageParamList();

		if (messageTemplateId == null || CollUtil.isEmpty(messageParamList)) {
			context.setNeedBreak(true);
			context.setResponse(BasicResultVO.fail(RespStatusEnum.CLIENT_BAD_PARAMETERS));
		}
	}
}
