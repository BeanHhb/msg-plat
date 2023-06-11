package com.beanh.msg.plat.common.enums;

/**
 * @author Bean
 * @date 2023/4/22 23:37
 */
public enum TemplateType {

	OPERATION(10, "运营类的模板"),
	TECHNOLOGY(20, "技术类的模板");

	TemplateType(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	private Integer code;
	private String description;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
