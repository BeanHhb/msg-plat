package com.beanh.msg.plat.support.pipeline;

import com.beanh.msg.plat.common.vo.BasicResultVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 责任链上下文
 *
 * @author huanghebin
 * @date 2023/6/13 14:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class ProcessContext {

	/**
	 * 标识责任链的code
	 */
	private String code;

	/**
	 * 存储责任链上下文数据的模型
	 */
	private ProcessModel processModel;

	/**
	 * 中断标志
	 */
	private Boolean needBreak;

	/**
	 * 流程处理的结果
	 */
	BasicResultVO response;
}
