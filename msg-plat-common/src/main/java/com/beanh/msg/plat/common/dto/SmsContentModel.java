package com.beanh.msg.plat.common.dto;

import lombok.Data;

/**
 * 短信内容模型
 *
 * @author huanghebin
 * @date 2023/6/14 10:47
 */
@Data
public class SmsContentModel extends ContentModel {

	/**
	 * 短信发送链接
	 */
	private String url;

	/**
	 * 短信发送内容
	 */
	private String content;
}
