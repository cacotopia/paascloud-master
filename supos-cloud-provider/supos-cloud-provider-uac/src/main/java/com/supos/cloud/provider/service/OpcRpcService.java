package com.supos.cloud.provider.service;

/**
 * The interface Opc rpc service.
 *
 * @author walkman
 */
public interface OpcRpcService {

	/**
	 * Gets location by id.
	 *
	 * @param addressId the address id
	 *
	 * @return the location by id
	 */
	String getLocationById(String addressId);
}
