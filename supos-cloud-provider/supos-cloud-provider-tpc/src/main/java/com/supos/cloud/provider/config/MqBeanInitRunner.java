package com.supos.cloud.provider.config;

import com.alibaba.fastjson.JSON;
import com.supos.cloud.base.constant.GlobalConstant;
import com.supos.cloud.config.properties.PaascloudProperties;
import com.supos.cloud.core.registry.RegistryCenterFactory;
import com.supos.cloud.core.registry.base.CoordinatorRegistryCenter;
import com.supos.cloud.core.registry.base.ReliableMessageRegisterDto;
import com.supos.cloud.provider.listener.MqConsumerChangeListener;
import com.supos.cloud.provider.listener.MqProducerChangeListener;
import com.supos.cloud.provider.service.MqProducerBeanFactory;
import com.supos.cloud.provider.service.TpcMqProducerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * The class Redis init runner.
 *
 * @author walkman
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class MqBeanInitRunner implements CommandLineRunner {
    @Resource
    private PaascloudProperties paascloudProperties;
    @Resource
    private MqProducerChangeListener producerChangeListener;
    @Resource
    private MqConsumerChangeListener consumerChangeListener;
    @Resource
    private TpcMqProducerService tpcMqProducerService;

    /**
     * Run.
     *
     * @param args the args
     */
    @Override
    public void run(String... args) throws Exception {
        CoordinatorRegistryCenter coordinatorRegistryCenter = RegistryCenterFactory.createCoordinatorRegistryCenter(paascloudProperties.getZk());
        List<String> childrenKeys = coordinatorRegistryCenter.getChildrenKeys(GlobalConstant.ZK_REGISTRY_PRODUCER_ROOT_PATH);
        this.initMqListener(coordinatorRegistryCenter);
        for (final String childrenKey : childrenKeys) {
            int count = coordinatorRegistryCenter.getNumChildren(GlobalConstant.ZK_REGISTRY_PRODUCER_ROOT_PATH + GlobalConstant.Symbol.SLASH + childrenKey);
            if (count == 0) {
                continue;
            }
            String producerString = coordinatorRegistryCenter.getDirectly(GlobalConstant.ZK_REGISTRY_PRODUCER_ROOT_PATH + GlobalConstant.Symbol.SLASH + childrenKey);
            ReliableMessageRegisterDto producerDto = JSON.parseObject(producerString, ReliableMessageRegisterDto.class);
            MqProducerBeanFactory.buildProducerBean(producerDto);
            try {
                tpcMqProducerService.updateOnLineStatusByPid(producerDto.getProducerGroup());
            } catch (Exception e) {
                log.error("更新生产者状态为离线出现异常, ex={}", e.getMessage(), e);
            }
        }
    }

    private void initMqListener(CoordinatorRegistryCenter coordinatorRegistryCenter) throws Exception {
        CuratorFramework cf = (CuratorFramework) coordinatorRegistryCenter.getRawClient();
        initProducerListener(cf);
        initConsumerListener(cf);
    }


    private void initProducerListener(CuratorFramework cf) throws Exception {
        TreeCache treeCache = new TreeCache(cf, GlobalConstant.ZK_REGISTRY_PRODUCER_ROOT_PATH);
        treeCache.getListenable().addListener(producerChangeListener);
        treeCache.start();
    }

    private void initConsumerListener(CuratorFramework cf) throws Exception {
        TreeCache treeCache = new TreeCache(cf, GlobalConstant.ZK_REGISTRY_CONSUMER_ROOT_PATH);
        treeCache.getListenable().addListener(consumerChangeListener);
        treeCache.start();
    }

}