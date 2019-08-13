package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.MdcExceptionLog;
import com.supos.cloud.provider.model.dto.MdcExceptionQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Mdc exception log mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface MdcExceptionLogMapper extends MyMapper<MdcExceptionLog> {
    /**
     * Query exception list with page list.
     *
     * @param mdcExceptionQueryDto the mdc exception query dto
     * @return the list
     */
    List<MdcExceptionLog> queryExceptionListWithPage(MdcExceptionQueryDto mdcExceptionQueryDto);
}