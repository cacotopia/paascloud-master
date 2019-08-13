package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.OpcSmsSetting;
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