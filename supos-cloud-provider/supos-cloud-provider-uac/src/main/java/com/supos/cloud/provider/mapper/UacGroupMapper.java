package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.UacGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * The interface Uac group mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface UacGroupMapper extends MyMapper<UacGroup> {
}