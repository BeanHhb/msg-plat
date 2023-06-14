package com.beanh.msg.plat.common.enums;

import com.beanh.msg.plat.common.dto.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 发送渠道类型枚举
 *
 * @author Bean
 * @date 2023/4/22 23:29
 */
@Getter
@ToString
@AllArgsConstructor
public enum ChannelType {
	IM(10, "IM(站内信)", ImContentModel.class),
	PUSH(20, "push(通知栏)", PushContentModel.class),
	SMS(30, "sms(短信)", SmsContentModel.class),
	EMAIL(40, "email(邮件)", EmailContentModel.class),
	OFFICIAL_ACCOUNT(50, "OfficialAccounts(服务号)", OfficialAccountContentModel.class),
	MINI_PROGRAM(60, "miniProgram(小程序)", MiniProgramContentModel.class);

	private Integer code;

	private String description;

	private Class contentModelClass;

	public static Class getChannelModelClassByCode(Integer code) {
		ChannelType[] values = values();
		for (ChannelType value : values) {
			if (value.getCode().equals(code)) {
				return value.getContentModelClass();
			}
		}
		return null;
	}
}
