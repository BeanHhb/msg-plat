package com.beanh.msg.plat.support.utils;

import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.PropertyPlaceholderHelper;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Properties;

/**
 * 内容占位符 替换
 *
 * @author huanghebin
 * @date 2023/6/14 11:01
 */
public class ContentHolderUtil {

	// 占位符前缀
	private static final String PLACE_HOLDER_PREFIX = "{$";
	// 占位符后缀
	private static final String PLACE_HOLDER_SUFFIX = "}";

	private static final StandardEvaluationContext evaluationContext;

	private static PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper(
			PLACE_HOLDER_PREFIX, PLACE_HOLDER_SUFFIX);

	static {
		evaluationContext = new StandardEvaluationContext();
		evaluationContext.addPropertyAccessor(new MapAccessor());
	}

	public static String replacePlaceHolder(final String template, final Map<String, String> paramMap) {
		String replaceContent = propertyPlaceholderHelper.replacePlaceholders(template,
				new CustomPlaceholderResolver(paramMap));
		return replaceContent;
	}

	private static class CustomPlaceholderResolver implements PropertyPlaceholderHelper.PlaceholderResolver {

		private Map<String, String> paramMap;

		public CustomPlaceholderResolver(Map<String, String> paramMap) {
			super();
			this.paramMap = paramMap;
		}

		@Override
		public String resolvePlaceholder(String placeholderName) {
			String value = paramMap.get(placeholderName);
			if (null == value) {
				String errorStr = MessageFormat.format("template:{} require param:{},but not exist! paramMap:{}",
						placeholderName, paramMap.toString());
				throw new IllegalArgumentException(errorStr);
			}
			return value;
		}
	}
}
