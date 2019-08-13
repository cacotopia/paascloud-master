package com.supos.cloud.provider.model.service.hystrix;

import com.supos.cloud.provider.model.dto.gaode.GaodeLocation;
import com.supos.cloud.provider.model.service.OpcGaodeFeignApi;
import com.supos.cloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

/**
 * The class Opc oss feign api hystrix.
 *
 * @author walkman
 */
@Component
public class OpcGaodeFeignApiHystrix implements OpcGaodeFeignApi {

	@Override
	public Wrapper<GaodeLocation> getLocationByIpAddr(final String ipAddr) {
		return null;
	}
}
