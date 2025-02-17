package com.supos.cloud.provider.service;

import com.supos.cloud.provider.model.dto.AddressDTO;

/**
 * The interface Omc order service.
 *
 * @author walkman
 */
public interface MdcAddressService {
	/**
	 * Gets address by id.
	 *
	 * @param addressId the address id
	 *
	 * @return the address by id
	 */
	AddressDTO getAddressById(Long addressId);
}
