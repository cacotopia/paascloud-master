package com.supos.cloud.provider.service.impl;

import com.google.common.collect.Lists;
import com.supos.cloud.RecursionTreeUtil;
import com.supos.cloud.TreeNode;
import com.supos.cloud.provider.mapper.MdcAddressMapper;
import com.supos.cloud.provider.model.domain.MdcAddress;
import com.supos.cloud.core.support.BaseService;
import com.supos.cloud.provider.service.MdcAddressService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Mdc address service.
 *
 * @author walkman
 */
@Service
public class MdcAddressServiceImpl extends BaseService<MdcAddress> implements MdcAddressService {
    @Resource
    private MdcAddressMapper mdcAddressMapper;

    /**
     * Find by pid list.
     *
     * @param pid the pid
     * @return the list
     */
    @Override
    public List<MdcAddress> listByPid(Long pid) {
        return mdcAddressMapper.selectAddressByPid(pid);
    }

    @Override
    @Cacheable(cacheNames = "mdc-cache", key = "#id")
    public MdcAddress getById(Long id) {
        return mdcAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(cacheNames = "mdc-cache", keyGenerator = "keyGenerator")
    public List<TreeNode> get4City() {
        List<MdcAddress> mdcAddresses = mdcAddressMapper.selectAll();
        List<TreeNode> treeNodeList = buildGroupTree(mdcAddresses);
        logger.info("treeNodeList={}", treeNodeList);
        return treeNodeList;
    }

    private List<TreeNode> buildGroupTree(List<MdcAddress> mdcAddressesList) {
        List<TreeNode> list = Lists.newArrayList();
        TreeNode node;
        for (MdcAddress group : mdcAddressesList) {
            node = new TreeNode();
            node.setId(group.getId());
            node.setPid(group.getPid());
            node.setNodeCode(group.getAdCode());
            node.setNodeName(group.getName());
            list.add(node);
        }

        return RecursionTreeUtil.getChildTreeNodes(list, 368100107951677440L);
    }
}
