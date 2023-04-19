package com.beanh.msg.plat.handler.scripts;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.beanh.msg.plat.common.pojo.SmsParam;
import com.google.common.base.Throwables;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 1. 发送短信接入文档：https://cloud.tencent.com/document/api/382/55981
 * 2. 推荐直接使用SDK
 * 3. 推荐使用API Explorer 生成代码
 *
 * @author Bean
 * @date 2023/4/17 22:50
 */
@Service
@Slf4j
public class TencentSmsScript {

	private static final String URL = "sms.tencentcloudapi.com";
	private static final String REGION = "ap-guangzhou";

	/**
	 * 账号相关
	 */
	private final static String SECRET_ID = "AKIDbQ4Tjpx6CC7vXv8GH4dzKf1ENNHAush4";
	private final static String SECRET_KEY = "HQQDoDOL3aCmCRVccT8dv37DJPRVbkwD";
	private static final String SMS_SDK_APP_ID = "1400412108";
	private static final String TEMPLATE_ID = "1770205";
	private static final String SIGN_NAME = "Bean的胡思乱想公众号";

	/**
	 * 发送短信
	 *
	 * @param smsParam
	 * @return
	 */
	public String send(SmsParam smsParam) {
		try {
			/*
			* 初始化client
			*/
			Credential cred = new Credential(SECRET_ID, SECRET_KEY);
			HttpProfile httpProfile = new HttpProfile();
			httpProfile.setEndpoint(URL);
			ClientProfile clientProfile = new ClientProfile();
			clientProfile.setHttpProfile(httpProfile);
			SmsClient client = new SmsClient(cred, REGION, clientProfile);

			/*
			 * 组装发送短信参数
			 */
			SendSmsRequest req = new SendSmsRequest();

			String[] phoneNumberSet1 = smsParam.getPhones().toArray(new String[smsParam.getPhones().size() - 1]);
			req.setPhoneNumberSet(phoneNumberSet1);
			req.setSmsSdkAppId(SMS_SDK_APP_ID);
			req.setSignName(SIGN_NAME);
			req.setTemplateId(TEMPLATE_ID);
			String[] templateParamSet1 = {smsParam.getContent()};
			req.setTemplateParamSet(templateParamSet1);
			req.setSessionContext(IdUtil.fastSimpleUUID());

			/*
			 * 请求，返回结果
			 */
			SendSmsResponse resp = client.SendSms(req);
			return SendSmsResponse.toJsonString(resp);

		} catch (TencentCloudSDKException e) {
			log.error("send tencent sms fail!{},params:{}",
					Throwables.getStackTraceAsString(e), JSON.toJSONString(smsParam));
			return null;
		}
	}
}
