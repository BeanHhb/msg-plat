package com.beanh.msg.plat.support.pipeline;

import java.util.List;

/**
 * 业务执行模板
 * 串联 多个具体的业务实现
 *
 * @author huanghebin
 * @date 2023/6/13 14:51
 */
public class ProcessTemplate {

	private List<BusinessProcess> processList;

	public List<BusinessProcess> getProcessList() {
		return this.processList;
	}

	public void setProcessList(List<BusinessProcess> processList) {
		this.processList = processList;
	}
}
