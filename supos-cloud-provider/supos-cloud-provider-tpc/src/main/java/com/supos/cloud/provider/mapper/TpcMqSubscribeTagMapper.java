package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.TpcMqSubscribeTag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * The interface Tpc mq subscribe tag mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface TpcMqSubscribeTagMapper extends MyMapper<TpcMqSubscribeTag> {
}