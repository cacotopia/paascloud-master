package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.TpcJobTask;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * The interface Tpc job task mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface TpcJobTaskMapper extends MyMapper<TpcJobTask> {
}