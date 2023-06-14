package com.beanh.msg.plat.handler.handler;

import com.beanh.msg.plat.common.domain.TaskInfo;

/**
 * @author Bean
 * @date 2023/5/7 17:05
 */
public interface Handler {

	boolean doHandler(TaskInfo taskInfo);
}
