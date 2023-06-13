package com.beanh.msg.plat.api.impl.config;

import com.beanh.msg.plat.api.enums.BusinessCode;
import com.beanh.msg.plat.api.impl.action.AssembleAction;
import com.beanh.msg.plat.api.impl.action.PreParamAction;
import com.beanh.msg.plat.api.impl.action.SendMqAction;
import com.beanh.msg.plat.support.pipeline.BusinessProcess;
import com.beanh.msg.plat.support.pipeline.ProcessController;
import com.beanh.msg.plat.support.pipeline.ProcessTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 责任链配置
 *
 * @author huanghebin
 * @date 2023/6/13 15:27
 */
@Configuration
public class PipelineConfig {

	/**
	 * 普通发送执行流程
	 *
	 * @return
	 */
	@Bean("commonSendTemplate")
	public ProcessTemplate commonSendTemplate() {
		ProcessTemplate processTemplate = new ProcessTemplate();
		List<BusinessProcess> processList = new ArrayList<BusinessProcess>();
		processList.add(preParamAction());
		processList.add(assembleAction());
		processList.add(sendMqAction());

		processTemplate.setProcessList(processList);
		return processTemplate;
	}

	/**
	 * pipeline流程控制器
	 *
	 * 后续扩展则加BusinessCode和ProcessTemplate
	 *
	 * @return
	 */
	@Bean
	public ProcessController processController() {
		ProcessController processController = new ProcessController();
		Map<String, ProcessTemplate> templateConfig = new HashMap<String, ProcessTemplate>();
		templateConfig.put(BusinessCode.COMMON_SEND.getCode(), commonSendTemplate());
		processController.setTemplateConfig(templateConfig);
		return processController;
	}

	/**
	 * 参数校验Action
	 *
	 * @return
	 */
	@Bean
	private BusinessProcess preParamAction() {
		return new PreParamAction();
	}

	/**
	 * 组装参数Action
	 *
	 * @return
	 */
	@Bean
	private BusinessProcess assembleAction() {
		return new AssembleAction();
	}

	/**
	 * 发送Mq消息Action
	 *
	 * @return
	 */
	@Bean
	private BusinessProcess sendMqAction() {
		return new SendMqAction();
	}
}
