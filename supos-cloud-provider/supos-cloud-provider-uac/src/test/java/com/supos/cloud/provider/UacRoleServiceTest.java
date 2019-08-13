package com.supos.cloud.provider;

import com.supos.cloud.base.constant.GlobalConstant;
import com.supos.cloud.provider.model.domain.UacRole;
import com.supos.cloud.provider.service.UacRoleService;
import org.junit.Test;

import javax.annotation.Resource;


/**
 * The class Uac role service test.
 * @author walkman
 */
public class UacRoleServiceTest extends PaasCloudUacApplicationTests {
	@Resource
	private UacRoleService uacRoleService;

	/**
	 * Find by login name test.
	 */
	@Test
	public void findByLoginNameTest() {
		UacRole admin = uacRoleService.findByRoleCode(GlobalConstant.Sys.SUPER_MANAGER_LOGIN_NAME);
		logger.info("findByLoginNameTest = {}", admin);
	}
}
