package com.supos.cloud.provider.service;

import com.github.pagehelper.PageInfo;
import com.supos.cloud.base.dto.LoginAuthDto;
import com.supos.cloud.core.support.IService;
import com.supos.cloud.provider.model.domain.OmcShipping;

import java.util.List;

/**
 * The interface Omc shipping service.
 *
 * @author walkman
 */
public interface OmcShippingService extends IService<OmcShipping> {
	/**
	 * 编辑收货人地址.
	 *
	 * @param loginAuthDto the login auth dto
	 * @param shipping     the shipping
	 *
	 * @return the int
	 */
	int saveShipping(LoginAuthDto loginAuthDto, OmcShipping shipping);

	/**
	 * 删除收货人地址.
	 *
	 * @param userId     the user id
	 * @param shippingId the shipping id
	 *
	 * @return the int
	 */
	int deleteShipping(Long userId, Integer shippingId);

	/**
	 * 根据Id查询收货人地址.
	 *
	 * @param userId     the user id
	 * @param shippingId the shipping id
	 *
	 * @return the omc shipping
	 */
	OmcShipping selectByShippingIdUserId(Long userId, Long shippingId);

	/**
	 * Query shipping list list.
	 *
	 * @param omcShipping the omc shipping
	 *
	 * @return the list
	 */
	List<OmcShipping> queryShippingList(OmcShipping omcShipping);

	/**
	 * 分页查询收货人地址列表.
	 *
	 * @param omcShipping the omc shipping
	 *
	 * @return the page info
	 */
	PageInfo queryShippingListWithPage(OmcShipping omcShipping);

	/**
	 * 分页查询当前用户收货人地址列表.
	 *
	 * @param userId   the user id
	 * @param pageNum  the page num
	 * @param pageSize the page size
	 *
	 * @return the page info
	 */
	PageInfo queryListWithPageByUserId(Long userId, int pageNum, int pageSize);

	/**
	 * Select by user id list.
	 *
	 * @param userId the user id
	 *
	 * @return the list
	 */
	List<OmcShipping> selectByUserId(Long userId);

	/**
	 * 设置默认收货地址.
	 *
	 * @param loginAuthDto the login auth dto
	 * @param addressId    the address id
	 *
	 * @return the default address
	 */
	int setDefaultAddress(LoginAuthDto loginAuthDto, Long addressId);
}