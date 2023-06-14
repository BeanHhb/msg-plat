package com.beanh.msg.plat.api.impl.action;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.beanh.msg.plat.api.domain.MessageParam;
import com.beanh.msg.plat.api.impl.domain.SendTaskModel;
import com.beanh.msg.plat.common.constant.CommonConstant;
import com.beanh.msg.plat.common.dto.ContentModel;
import com.beanh.msg.plat.common.enums.ChannelType;
import com.beanh.msg.plat.common.enums.RespStatusEnum;
import com.beanh.msg.plat.common.domain.TaskInfo;
import com.beanh.msg.plat.common.vo.BasicResultVO;
import com.beanh.msg.plat.support.dao.MessageTemplateDao;
import com.beanh.msg.plat.support.domain.MessageTemplate;
import com.beanh.msg.plat.support.pipeline.BusinessProcess;
import com.beanh.msg.plat.support.pipeline.ProcessContext;
import com.beanh.msg.plat.support.utils.ContentHolderUtil;
import com.beanh.msg.plat.support.utils.TaskInfoUtils;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.*;

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
					.messageTemplateId(messageTemplate.getId())
					.businessId(TaskInfoUtils.generateBusinessId(messageTemplate.getId(), messageTemplate.getTemplateType()))
					.receiver(new HashSet<>(Arrays.asList(messageParam.getReceiver().split(String.valueOf(StrUtil.C_COMMA)))))
					.idType(messageTemplate.getIdType())
					.sendChannel(messageTemplate.getSendChannel())
					.templateType(messageTemplate.getTemplateType())
					.msgType(messageTemplate.getMsgType())
					.sendAccount(messageTemplate.getSendAccount())
					.contentModel(getContentModelValue(messageTemplate, messageParam))
					.build();
			taskInfoList.add(taskInfo);
		}
		return taskInfoList;
	}

	/**
	 * 获取 contentModel,替换占位符信息
	 *
	 * @param messageTemplate
	 * @param messageParam
	 * @return
	 */
	private static ContentModel getContentModelValue(MessageTemplate messageTemplate, MessageParam messageParam) {
		Integer sendChannel = messageTemplate.getSendChannel();
		Map<String, String> variables = messageParam.getVariables();
		JSONObject jsonObject = JSONUtil.parseObj(messageTemplate.getMsgContent());
		Class contentModelClass = ChannelType.getChannelModelClassByCode(sendChannel);

		// 反射获取得到不同的渠道对应的值
		Field[] fields = ReflectUtil.getFields(contentModelClass);
		ContentModel contentModel = (ContentModel) ReflectUtil.newInstance(contentModelClass);
		for (Field field : fields) {
			String originValue = jsonObject.getStr(field.getName());
			if (StrUtil.isNotBlank(originValue)) {
				String resultValue = ContentHolderUtil.replacePlaceHolder(originValue, variables);
				ReflectUtil.setFieldValue(contentModel, field, resultValue);
			}
		}
		return contentModel;
	}

	/**
	 * for test
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		MessageTemplate messageTemplate = MessageTemplate.builder().sendChannel(ChannelType.SMS.getCode()).msgContent("{\"url\":\"www.baidu.com/{$urlParam}\",\"content\":\"{$contentValue}\"}").build();
		HashMap<String, String> map = new HashMap<>();
		map.put("urlParam", "2222");
		map.put("contentValue", "3333");
		MessageParam messageParam = new MessageParam();
		messageParam.setVariables(map);

		ContentModel contentModelValue = getContentModelValue(messageTemplate, messageParam);
		System.out.println(JSON.toJSONString(contentModelValue));
	}
}
