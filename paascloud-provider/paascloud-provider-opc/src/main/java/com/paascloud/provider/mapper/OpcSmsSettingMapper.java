package com.paascloud.provider.mapper;

import com.paascloud.core.mybatis.MyMapper;
import com.paascloud.provider.model.domain.OpcSmsSetting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * The interface Opc sms setting mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface OpcSmsSettingMapper extends MyMapper<OpcSmsSetting> {
}