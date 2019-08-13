package com.supos.cloud.provider.web.frontend;


import com.supos.cloud.TreeNode;
import com.supos.cloud.provider.service.MdcAddressService;
import com.supos.cloud.core.support.BaseController;
import com.supos.cloud.wrapper.WrapMapper;
import com.supos.cloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Mdc address rest.
 *
 * @author walkman
 */
@RestController
@RequestMapping(value = "/address", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - MdcAddressRest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MdcAddressRest extends BaseController {

	@Resource
	private MdcAddressService mdcAddressService;


	/**
	 * Gets 4 city.
	 *
	 * @return the 4 city
	 */
	@PostMapping(value = "/get4City")
	@ApiOperation(httpMethod = "POST", value = "查看四级地址")
	public Wrapper<List<TreeNode>> get4City() {
		logger.info("get4City - 获取四级地址");
		List<TreeNode> treeNodeList = mdcAddressService.get4City();
		return WrapMapper.ok(treeNodeList);
	}

}
