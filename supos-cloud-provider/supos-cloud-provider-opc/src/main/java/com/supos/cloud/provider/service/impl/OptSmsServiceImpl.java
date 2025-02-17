package com.supos.cloud.provider.service.impl;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.google.common.base.Preconditions;
import com.supos.cloud.base.constant.GlobalConstant;
import com.supos.cloud.base.enums.ErrorCodeEnum;
import com.supos.cloud.config.properties.PaascloudProperties;
import com.supos.cloud.provider.model.exceptions.OpcBizException;
import com.supos.cloud.provider.service.OptSmsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * The class Opt sms service.
 *
 * @author walkman
 */
@Slf4j
@Service
public class OptSmsServiceImpl implements OptSmsService {

    @Resource
    private IAcsClient iAcsClient;

    @Resource
    private PaascloudProperties paascloudProperties;

    @Value("${spring.profiles.active}")
    private String profile;

    @Override
    public SendSmsResponse sendSms(SendSmsRequest sendSmsRequest) {
        checkParam(sendSmsRequest);
        SendSmsResponse acsResponse;
        try {
            if (GlobalConstant.DEV_PROFILE.equals(profile)) {
                log.error("dev环境不发送短信");
                return new SendSmsResponse();
            }
            if (GlobalConstant.TEST_PROFILE.equals(profile)) {
                log.error("test环境不发送短信");
                return new SendSmsResponse();
            }
            acsResponse = iAcsClient.getAcsResponse(sendSmsRequest);
        } catch (ClientException e) {
            log.error("send sms message error={}", e.getMessage(), e);
            throw new OpcBizException(ErrorCodeEnum.OPC10040004, e);
        }
        log.info("send sms message OK acsResponse={}", acsResponse);
        return acsResponse;
    }

    private void checkParam(SendSmsRequest sendSmsRequest) {
        String templateCode = sendSmsRequest.getTemplateCode();
        String signName = sendSmsRequest.getSignName();
        if (StringUtils.isBlank(signName)) {
            sendSmsRequest.setSignName(paascloudProperties.getAliyun().getSms().getSignName());
        }

        String templateParam = sendSmsRequest.getTemplateParam();
        String phoneNumbers = sendSmsRequest.getPhoneNumbers();

        Preconditions.checkArgument(StringUtils.isNotEmpty(templateCode), "短信模板不能为空");
        Preconditions.checkArgument(StringUtils.isNotEmpty(phoneNumbers), "手机号码不能为空");
        Preconditions.checkArgument(StringUtils.isNotEmpty(templateParam), "短信内容不能为空");
    }
}
