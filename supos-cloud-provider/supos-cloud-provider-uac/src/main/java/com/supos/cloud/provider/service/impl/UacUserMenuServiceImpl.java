package com.supos.cloud.provider.service.impl;


import com.supos.cloud.core.support.BaseService;
import com.supos.cloud.provider.model.domain.UacUserMenu;
import com.supos.cloud.provider.service.UacUserMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The class Uac user menu service.
 *
 * @author walkman
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UacUserMenuServiceImpl extends BaseService<UacUserMenu> implements UacUserMenuService {
}
