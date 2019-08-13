package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.MdcProductCategory;
import com.supos.cloud.provider.model.dto.ProductCategoryDto;
import com.supos.cloud.provider.model.vo.MdcCategoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Mdc product category mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface MdcProductCategoryMapper extends MyMapper<MdcProductCategory> {
    /**
     * Select category dto list list.
     *
     * @param categoryPid the category pid
     * @return the list
     */
    List<ProductCategoryDto> selectCategoryDtoList(Long categoryPid);

    /**
     * List category vo list.
     *
     * @return the list
     */
    List<MdcCategoryVo> listCategoryVo();
}