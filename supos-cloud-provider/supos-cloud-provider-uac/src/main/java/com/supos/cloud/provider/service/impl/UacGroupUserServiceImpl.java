package com.supos.cloud.provider.service.impl;

import com.supos.cloud.core.support.BaseService;
import com.supos.cloud.provider.mapper.UacGroupUserMapper;
import com.supos.cloud.provider.model.domain.UacGroup;
import com.supos.cloud.provider.model.domain.UacGroupUser;
import com.supos.cloud.provider.service.UacGroupUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Uac group user service.
 *
 * @author walkman
 */
@Service
public class UacGroupUserServiceImpl extends BaseService<UacGroupUser> implements UacGroupUserService {
	@Resource
	private UacGroupUserMapper uacGroupUserMapper;

	@Override
	public UacGroupUser queryByUserId(Long userId) {
		return uacGroupUserMapper.getByUserId(userId);
	}

	@Override
	public int updateByUserId(UacGroupUser uacGroupUser) {
		return uacGroupUserMapper.updateByUserId(uacGroupUser);
	}

	@Override
	public List<UacGroup> getGroupListByUserId(Long userId) {
		return uacGroupUserMapper.selectGroupListByUserId(userId);
	}

	@Override
	public void saveUserGroup(Long userId, Long groupId) {
		UacGroupUser groupUser = new UacGroupUser();
		groupUser.setUserId(userId);
		groupUser.setGroupId(groupId);
		uacGroupUserMapper.insertSelective(groupUser);
	}
}
