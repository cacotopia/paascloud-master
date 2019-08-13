package com.supos.cloud.provider.service.impl;

import com.google.common.base.Preconditions;
import com.supos.cloud.PublicUtil;
import com.supos.cloud.provider.service.OptFreeMarkerService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * The class Opt free marker service.
 *
 * @author walkman
 */
@Service
public class OptFreeMarkerServiceImpl implements OptFreeMarkerService {

    @Resource
    private Configuration configuration;

    @Override
    public String getTemplate(Map<String, Object> map, String templateLocation) throws IOException, TemplateException {
        Preconditions.checkArgument(PublicUtil.isNotEmpty(templateLocation), "模板不能为空");
        Template t = configuration.getTemplate(templateLocation, "UTF-8");
        return FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
    }
}
