package com.supos.cloud.provider;

import com.supos.cloud.provider.model.vo.MenuVo;
import com.supos.cloud.provider.service.UacMenuService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class UacMenuServiceTest extends PaasCloudUacApplicationTests {
	@Resource
	private UacMenuService uacMenuService;

	@Test
	public void findMenuListByUserIdTest() {
		List<MenuVo> menuVoListByUserId = uacMenuService.getMenuVoList(1L, 1L);
		logger.info("findByLoginNameTest = {}", menuVoListByUserId);
	}
}
