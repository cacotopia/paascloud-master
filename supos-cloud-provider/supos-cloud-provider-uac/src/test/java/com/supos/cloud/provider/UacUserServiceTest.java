package com.supos.cloud.provider;

import com.github.pagehelper.PageInfo;
import com.supos.cloud.provider.model.domain.UacUser;
import com.supos.cloud.provider.service.UacUserService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;


/**
 * The class Uac user service test.
 * @author walkman
 */
public class UacUserServiceTest extends PaasCloudUacApplicationTests {
	@Resource
	private UacUserService uacUserService;

	/**
	 * Find by login name test.
	 */
	@Test
	public void findByLoginNameTest() {
		List<UacUser> uacUsers = uacUserService.selectAll();
		logger.info("findByLoginNameTest = {}", uacUsers);
	}

	/**
	 * Query user list with page test.
	 */
	@Test
	public void queryUserListWithPageTest() {
		PageInfo pageInfo = uacUserService.queryUserListWithPage(new UacUser());
		logger.info("queryUserListWithPage = {}", pageInfo);
	}


}
