package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.PtcPayInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * The interface Ptc pay info mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface PtcPayInfoMapper extends MyMapper<PtcPayInfo> {
}