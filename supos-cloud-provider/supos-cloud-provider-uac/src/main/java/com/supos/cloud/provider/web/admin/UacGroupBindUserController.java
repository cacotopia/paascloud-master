package com.supos.cloud.provider.web.admin;


import com.supos.cloud.base.dto.LoginAuthDto;
import com.supos.cloud.core.annotation.LogAnnotation;
import com.supos.cloud.core.support.BaseController;
import com.supos.cloud.provider.model.dto.group.GroupBindUserDto;
import com.supos.cloud.provider.model.dto.group.GroupBindUserReqDto;
import com.supos.cloud.provider.service.UacGroupService;
import com.supos.cloud.wrapper.WrapMapper;
import com.supos.cloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 组织绑定用户.
 *
 * @author walkman
 */
@RestController
@RequestMapping(value = "/group", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - UacGroupBindUserController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacGroupBindUserController extends BaseController {

	@Resource
	private UacGroupService uacGroupService;

	/**
	 * 组织绑定用户
	 *
	 * @param groupBindUserReqDto the group bind user req dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/bindUser")
	@LogAnnotation
	@ApiOperation(httpMethod = "POST", value = "组织绑定用户")
	public Wrapper bindUser4Role(@ApiParam(name = "uacGroupBindUserReqDto", value = "组织绑定用户") @RequestBody GroupBindUserReqDto groupBindUserReqDto) {
		logger.info("组织绑定用户...  groupBindUserReqDto={}", groupBindUserReqDto);
		LoginAuthDto loginAuthDto = super.getLoginAuthDto();
		uacGroupService.bindUacUser4Group(groupBindUserReqDto, loginAuthDto);
		return WrapMapper.ok();
	}

	/**
	 * 组织绑定用户页面数据
	 *
	 * @param groupId the group id
	 *
	 * @return the group bind user page info
	 */
	@PostMapping(value = "/getBindUser/{groupId}")
	@ApiOperation(httpMethod = "POST", value = "获取组织绑定用户页面数据")
	public Wrapper<GroupBindUserDto> getGroupBindUserPageInfo(@ApiParam(name = "groupId", value = "组织id") @PathVariable Long groupId) {
		logger.info("查询组织绑定用户页面数据 groupId={}", groupId);
		LoginAuthDto loginAuthDto = super.getLoginAuthDto();
		Long currentUserId = loginAuthDto.getUserId();
		GroupBindUserDto bindUserDto = uacGroupService.getGroupBindUserDto(groupId, currentUserId);
		return WrapMapper.ok(bindUserDto);
	}
}
