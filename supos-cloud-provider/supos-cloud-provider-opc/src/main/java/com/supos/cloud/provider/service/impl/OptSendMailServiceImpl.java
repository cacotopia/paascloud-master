package com.supos.cloud.provider.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.supos.cloud.PubUtils;
import com.supos.cloud.PublicUtil;
import com.supos.cloud.base.enums.ErrorCodeEnum;
import com.supos.cloud.provider.model.exceptions.OpcBizException;
import com.supos.cloud.provider.model.dto.mail.MailEntity;
import com.supos.cloud.provider.service.OptFreeMarkerService;
import com.supos.cloud.provider.service.OptSendMailService;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * The class Opt send mail service.
 *
 * @author walkman
 */
@Slf4j
@Service
public class OptSendMailServiceImpl implements OptSendMailService {

    @Resource
    private TaskExecutor taskExecutor;

    @Resource
    private OptFreeMarkerService optVelocityService;

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public int sendSimpleMail(String subject, String text, Set<String> to) {
        log.info("sendSimpleMail - 发送简单邮件. subject={}, text={}, to={}", subject, text, to);
        int result = 1;
        try {
            SimpleMailMessage message = MailEntity.createSimpleMailMessage(subject, text, to);
            message.setFrom(from);
            taskExecutor.execute(() -> mailSender.send(message));
        } catch (Exception e) {
            log.info("sendSimpleMail [FAIL] ex={}", e.getMessage(), e);
            result = 0;
        }
        return result;
    }

    @Override
    public int sendTemplateMail(String subject, String text, Set<String> to) {
        log.info("sendTemplateMail - 发送模板邮件. subject={}, text={}, to={}", subject, text, to);
        int result = 1;
        try {
            MimeMessage mimeMessage = getMimeMessage(subject, text, to);
            taskExecutor.execute(() -> mailSender.send(mimeMessage));
        } catch (Exception e) {
            log.info("sendTemplateMail [FAIL] ex={}", e.getMessage(), e);
            result = 0;
        }
        return result;
    }

    private MimeMessage getMimeMessage(String subject, String text, Set<String> to) {
        Preconditions.checkArgument(!PubUtils.isNull(subject, text, to), "参数异常, 邮件信息不完整");

        String[] toArray = setToArray(to);
        Preconditions.checkArgument(PublicUtil.isNotEmpty(toArray), "请输入收件人邮箱");
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(toArray);
            helper.setSubject(subject);
            helper.setText(text, true);
        } catch (MessagingException e) {
            log.error("生成邮件消息体, 出现异常={}", e.getMessage(), e);
            throw new OpcBizException(ErrorCodeEnum.OPC10040005);
        }
        return mimeMessage;
    }

    @Override
    public int sendTemplateMail(Map<String, Object> model, String templateLocation, String subject, Set<String> to) {
        log.info("sendTemplateMail - 发送模板邮件. subject={}, model={}, to={}, templateLocation={}", subject, model, to, templateLocation);

        String text;
        try {
            text = optVelocityService.getTemplate(model, templateLocation);
        } catch (IOException | TemplateException e) {
            log.info("sendTemplateMail [FAIL] ex={}", e.getMessage(), e);
            throw new OpcBizException(ErrorCodeEnum.OPC10040006, e);
        }
        return this.sendTemplateMail(subject, text, to);
    }


    private String[] setToArray(Set<String> to) {
        Preconditions.checkArgument(PublicUtil.isNotEmpty(to), "请输入收件人邮箱");

        Set<String> toSet = Sets.newHashSet();
        for (String toStr : to) {
            toStr = toStr.trim();
            if (PubUtils.isEmail(toStr)) {
                toSet.add(toStr);
            }
        }
        if (PublicUtil.isEmpty(toSet)) {
            return null;
        }
        return toSet.toArray(new String[toSet.size()]);
    }


}
