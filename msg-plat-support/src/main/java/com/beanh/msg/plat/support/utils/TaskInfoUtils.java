package com.beanh.msg.plat.support.utils;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * 生成 消息推送的URL 工具类
 *
 * @author huanghebin
 * @date 2023/6/14 9:53
 */
public class TaskInfoUtils {

	private static int TYPE_FLAG = 1000000;

	/**
	 * 生成BusinessId
	 * 模板类型+模板ID+当天日期
	 * （16位）
	 *
	 * @param templateId
	 * @param templateType
	 * @return
	 */
	public static Long generateBusinessId(Long templateId, Integer templateType) {
		Integer today = Integer.valueOf(DateUtil.format(new Date(), "yyyyMMdd"));
		return Long.valueOf(String.format("%d%s", templateType * TYPE_FLAG + templateId, today));
	}
}
