package com.supos.cloud.provider.service;

import com.supos.cloud.base.dto.LoginAuthDto;
import com.supos.cloud.base.dto.UpdateStatusDto;
import com.supos.cloud.core.support.IService;
import com.supos.cloud.provider.model.domain.MdcDict;
import com.supos.cloud.provider.model.vo.MdcDictVo;

import java.util.List;

/**
 * The interface Mdc dict service.
 *
 * @author walkman
 */
public interface MdcDictService extends IService<MdcDict> {

    /**
     * 获取字典树.
     *
     * @return the dict tree list
     */
    List<MdcDictVo> getDictTreeList();

    /**
     * 根据ID获取字典信息.
     *
     * @param dictId the dict id
     * @return the mdc dict vo by id
     */
    MdcDictVo getMdcDictVoById(Long dictId);

    /**
     * 根据id修改字典信息.
     *
     * @param updateStatusDto the update status dto
     * @param loginAuthDto    the login auth dto
     * @return the int
     */
    void updateMdcDictStatusById(UpdateStatusDto updateStatusDto, LoginAuthDto loginAuthDto);

    /**
     * 编辑字典.
     *
     * @param mdcDict      the mdc dict
     * @param loginAuthDto the login auth dto
     */
    void saveMdcDict(MdcDict mdcDict, LoginAuthDto loginAuthDto);

    /**
     * Check dict has child dict boolean.
     *
     * @param dictId the dict id
     * @return the boolean
     */
    boolean checkDictHasChildDict(Long dictId);
}
