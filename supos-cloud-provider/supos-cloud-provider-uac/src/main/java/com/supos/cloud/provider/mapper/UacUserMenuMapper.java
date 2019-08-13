package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.UacUserMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * The interface Uac user menu mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface UacUserMenuMapper extends MyMapper<UacUserMenu> {
}