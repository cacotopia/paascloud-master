package com.supos.cloud.provider.annotation;

import com.supos.cloud.provider.model.enums.DelayLevelEnum;
import com.supos.cloud.provider.model.enums.MqOrderTypeEnum;
import com.supos.cloud.provider.model.enums.MqSendTypeEnum;

import java.lang.annotation.*;


/**
 * 保存生产者消息.
 *
 * @author walkman
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MqProducerStore {
	MqSendTypeEnum sendType() default MqSendTypeEnum.WAIT_CONFIRM;

	MqOrderTypeEnum orderType() default MqOrderTypeEnum.ORDER;

	DelayLevelEnum delayLevel() default DelayLevelEnum.ZERO;
}
