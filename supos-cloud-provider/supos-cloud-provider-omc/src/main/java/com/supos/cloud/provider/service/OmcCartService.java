package com.supos.cloud.provider.service;

import com.supos.cloud.base.dto.LoginAuthDto;
import com.supos.cloud.core.support.IService;
import com.supos.cloud.provider.model.domain.OmcCart;
import com.supos.cloud.provider.model.domain.OmcOrderDetail;
import com.supos.cloud.provider.model.vo.CartProductVo;
import com.supos.cloud.provider.model.vo.CartVo;
import com.supos.cloud.provider.model.vo.OrderProductVo;

import java.util.List;

/**
 * The interface Omc cart service.
 *
 * @author walkman
 */
public interface OmcCartService extends IService<OmcCart> {
	/**
	 * 获取购物车信息.
	 *
	 * @param userId the user id
	 *
	 * @return the car vo
	 */
	CartVo getCarVo(Long userId);

	/**
	 * Select cart list by user id list.
	 *
	 * @param userId the user id
	 *
	 * @return the list
	 */
	List<OmcCart> selectCartListByUserId(Long userId);

	/**
	 * 更新购物车.
	 *
	 * @param cartProductVoList the cart product vo list
	 *
	 * @return the int
	 */
	int updateCartList(List<CartProductVo> cartProductVoList);

	/**
	 * Save cart.
	 *
	 * @param omcCart the omc cart
	 * @param authDto the auth dto
	 */
	void saveCart(OmcCart omcCart, LoginAuthDto authDto);

	/**
	 * 保存购物车信息.
	 *
	 * @param userId    the user id
	 * @param productId the product id
	 * @param count     the count
	 *
	 * @return the int
	 */
	int saveCart(Long userId, Long productId, int count);

	/**
	 * Gets cart by user id and product id.
	 *
	 * @param userId    the user id
	 * @param productId the product id
	 *
	 * @return the cart by user id and product id
	 */
	OmcCart getCartByUserIdAndProductId(Long userId, Long productId);

	/**
	 * 删除购物车商品信息.
	 *
	 * @param userId     the user id
	 * @param productIds the product ids
	 *
	 * @return the int
	 */
	int deleteProduct(Long userId, String productIds);

	/**
	 * 选中或者反选商品信息.
	 *
	 * @param userId    the user id
	 * @param productId the product id
	 * @param checked   the checked
	 *
	 * @return the int
	 */
	int selectOrUnSelect(Long userId, Long productId, int checked);

	/**
	 * 更新购物车信息.
	 *
	 * @param userId    the user id
	 * @param productId the product id
	 * @param count     the count
	 *
	 * @return the int
	 */
	int updateCart(Long userId, Long productId, int count);

	/**
	 * 获取购物车商品数量.
	 *
	 * @param userId the user id
	 *
	 * @return the or cart product
	 */
	OrderProductVo getOrderCartProduct(Long userId);

	/**
	 * Gets cart order item.
	 *
	 * @param userId   the user id
	 * @param cartList the cart list
	 *
	 * @return the cart order item
	 */
	List<OmcOrderDetail> getCartOrderItem(Long userId, List<OmcCart> cartList);
}
