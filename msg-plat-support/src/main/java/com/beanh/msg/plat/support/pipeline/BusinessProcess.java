package com.beanh.msg.plat.support.pipeline;

/**
 * 业务执行器
 *
 * @author huanghebin
 * @date 2023/6/13 14:52
 */
public interface BusinessProcess {

	/**
	 * 真正处理逻辑
	 *
	 * @param context
	 */
	void process(ProcessContext context);
}
