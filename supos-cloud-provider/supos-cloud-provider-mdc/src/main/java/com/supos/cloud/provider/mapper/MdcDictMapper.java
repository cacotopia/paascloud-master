package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.MdcDict;
import com.supos.cloud.provider.model.vo.MdcDictVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Mdc dict mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface MdcDictMapper extends MyMapper<MdcDict> {
    /**
     * List dict vo list.
     *
     * @return the list
     */
    List<MdcDictVo> listDictVo();
}