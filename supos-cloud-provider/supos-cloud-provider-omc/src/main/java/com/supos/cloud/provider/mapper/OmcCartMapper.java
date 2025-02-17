package com.supos.cloud.provider.mapper;

import com.supos.cloud.core.mybatis.MyMapper;
import com.supos.cloud.provider.model.domain.OmcCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Omc cart mapper.
 *
 * @author walkman
 */
@Mapper
@Component
public interface OmcCartMapper extends MyMapper<OmcCart> {
    /**
     * Select un checked cart product count by user id int.
     *
     * @param userId the user id
     * @return the int
     */
    int selectUnCheckedCartProductCountByUserId(Long userId);

    /**
     * Select by product id and user id omc cart.
     *
     * @param productId the product id
     * @param userId    the user id
     * @return the omc cart
     */
    OmcCart selectByProductIdAndUserId(@Param("productId") Long productId, @Param("userId") Long userId);

    /**
     * Delete by user id product ids int.
     *
     * @param userId        the user id
     * @param productIdList the product id list
     * @return the int
     */
    int deleteByUserIdProductIds(@Param("userId") Long userId, @Param("productIdList") List<String> productIdList);

    /**
     * Checked or unchecked product int.
     *
     * @param userId    the user id
     * @param productId the product id
     * @param checked   the checked
     * @return the int
     */
    int checkedOrUncheckedProduct(@Param("userId") Long userId, @Param("productId") Long productId, @Param("checked") int checked);

    /**
     * Select cart product count int.
     *
     * @param userId the user id
     * @return the int
     */
    int selectCartProductCount(Long userId);

    /**
     * Select checked cart by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<OmcCart> selectCheckedCartByUserId(Long userId);

    /**
     * Batch delete cart int.
     *
     * @param idList the id list
     * @return the int
     */
    int batchDeleteCart(@Param("idList") List<Long> idList);
}