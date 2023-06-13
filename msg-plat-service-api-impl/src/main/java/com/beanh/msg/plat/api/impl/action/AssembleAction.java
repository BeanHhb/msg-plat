package com.beanh.msg.plat.api.impl.action;

import com.beanh.msg.plat.api.domain.MessageParam;
import com.beanh.msg.plat.api.impl.domain.SendTaskModel;
import com.beanh.msg.plat.common.constant.CommonConstant;
import com.beanh.msg.plat.common.enums.RespStatusEnum;
import com.beanh.msg.plat.common.pojo.TaskInfo;
import com.beanh.msg.plat.common.pojo.vo.BasicResultVO;
import com.beanh.msg.plat.support.dao.MessageTemplateDao;
import com.beanh.msg.plat.support.domain.MessageTemplate;
import com.beanh.msg.plat.support.pipeline.BusinessProcess;
import com.beanh.msg.plat.support.pipeline.ProcessContext;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 组装参数
 *
 * @author huanghebin
 * @date 2023/6/13 16:44
 */
@Slf4j
public class AssembleAction implements BusinessProcess {

	@Autowired
	private MessageTemplateDao messageTemplateDao;

	@Override
	public void process(ProcessContext context) {

		SendTaskModel sendTaskModel = (SendTaskModel) context.getProcessModel();
		Long messageTemplateId = sendTaskModel.getMessageTemplateId();

		try {
			Optional<MessageTemplate> messageTemplateOpt = messageTemplateDao.findById(messageTemplateId);
			if (!messageTemplateOpt.isPresent() || messageTemplateOpt.get().getIsDeleted().equals(CommonConstant.TRUE)) {
				context.setNeedBreak(true);
				context.setResponse(BasicResultVO.fail(RespStatusEnum.TEMPLATE_NOT_FOUND));
				return;
			}
			List<TaskInfo> taskInfos = assembleTaskInfo(sendTaskModel, messageTemplateOpt.get());
			sendTaskModel.setTaskInfo(taskInfos);
		} catch (Exception e) {
			context.setNeedBreak(true);
			context.setResponse(BasicResultVO.fail(RespStatusEnum.SERVICE_ERROR));
			log.error("assemble task fail! templateId:{}, e:{}", messageTemplateId, Throwables.getStackTraceAsString(e));
		}
	}

	/**
	 * 组装 TaskInfo 任务消息
	 *
	 * @param sendTaskModel
	 * @param messageTemplate
	 * @return
	 */
	private List<TaskInfo> assembleTaskInfo(SendTaskModel sendTaskModel, MessageTemplate messageTemplate) {

		List<MessageParam> messageParamList = sendTaskModel.getMessageParamList();
		List<TaskInfo> taskInfoList = new ArrayList<>();

		for (MessageParam messageParam : messageParamList) {
			TaskInfo taskInfo = TaskInfo.builder()

					.build();
			taskInfoList.add(taskInfo);
		}
		return taskInfoList;
	}


}
