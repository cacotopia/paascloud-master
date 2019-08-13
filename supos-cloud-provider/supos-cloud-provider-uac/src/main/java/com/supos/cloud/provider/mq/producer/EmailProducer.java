package com.supos.cloud.provider.mq.producer;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.supos.cloud.RedisKeyUtil;
import com.supos.cloud.base.constant.AliyunMqTopicConstants;
import com.supos.cloud.base.enums.ErrorCodeEnum;
import com.supos.cloud.provider.model.domain.MqMessageData;
import com.supos.cloud.provider.model.dto.PcSendEmailRequest;
import com.supos.cloud.provider.model.enums.UacEmailTemplateEnum;
import com.supos.cloud.provider.model.exceptions.UacBizException;
import com.supos.cloud.provider.service.UacFreeMarkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * The class Email producer.
 *
 * @author walkman
 */
@Component
@Slf4j
public class EmailProducer {
	@Resource
	private UacFreeMarkerService uacFreeMarkerService;

	/**
	 * Send email mq.
	 *
	 * @param emailSet          the email set
	 * @param emailTemplateEnum the email template enum
	 * @param param             the param
	 */
	public MqMessageData sendEmailMq(Set<String> emailSet, UacEmailTemplateEnum emailTemplateEnum, AliyunMqTopicConstants.MqTagEnum tagEnum, Map<String, Object> param) {
		log.info("pcSendEmailRequest - 发送邮件MQ. emailSet={}, param={}", emailSet, param);
		String msgBody;
		try {

			Preconditions.checkArgument(emailTemplateEnum != null, "邮箱模板信息不存在");
			PcSendEmailRequest request = new PcSendEmailRequest();

			String templateLocation = emailTemplateEnum.getLocation();
			String text = uacFreeMarkerService.getTemplate(param, templateLocation);

			request.setText(text);
			request.setTo(emailSet);
			request.setSubject(emailTemplateEnum.getSubject());

			msgBody = JSON.toJSONString(request);
		} catch (Exception e) {
			log.error("发送邮件验证码 smsMessage转换为json字符串失败", e);
			throw new UacBizException(ErrorCodeEnum.UAC10011021);
		}
		String topic = tagEnum.getTopic();
		String tag = tagEnum.getTag();
		String key = RedisKeyUtil.createMqKey(topic, tag, emailSet.toString(), msgBody);
		return new MqMessageData(msgBody, topic, tag, key);
	}
}
