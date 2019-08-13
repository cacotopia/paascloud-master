package com.supos.cloud.provider.service.impl;

import com.supos.cloud.base.constant.GlobalConstant;
import com.supos.cloud.base.enums.ErrorCodeEnum;
import com.supos.cloud.provider.model.exceptions.MdcBizException;
import com.supos.cloud.provider.model.dto.gaode.GaodeLocation;
import com.supos.cloud.provider.model.service.OpcGaodeFeignApi;
import com.supos.cloud.provider.service.OpcRpcService;
import com.supos.cloud.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * The class Opc rpc service.
 *
 * @author walkman
 */
@Slf4j
@Service
public class OpcRpcServiceImpl implements OpcRpcService {
	@Resource
	private OpcGaodeFeignApi opcGaodeFeignApi;

	@Override
	public String getLocationById(String addressId) {
		try {
			Wrapper<GaodeLocation> wrapper = opcGaodeFeignApi.getLocationByIpAddr(addressId);
			if (wrapper == null) {
				throw new MdcBizException(ErrorCodeEnum.GL99990002);
			}
			if (wrapper.error()) {
				throw new MdcBizException(ErrorCodeEnum.MDC10021002);
			}

			GaodeLocation result = wrapper.getResult();

			assert result != null;
			return result.getProvince().contains("市") ? result.getCity() : result.getProvince() + GlobalConstant.Symbol.SHORT_LINE + result.getCity();
		} catch (Exception e) {
			log.error("getLocationById={}", e.getMessage(), e);
		}
		return null;
	}
}
