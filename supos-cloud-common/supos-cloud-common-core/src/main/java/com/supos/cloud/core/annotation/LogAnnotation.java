package com.supos.cloud.core.annotation;

import com.supos.cloud.core.enums.LogTypeEnum;

import java.lang.annotation.*;


/**
 * 操作日志.
 *
 * @author walkman
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    /**
     * 日志类型
     *
     * @return the log type enum
     */
    LogTypeEnum logType() default LogTypeEnum.OPERATION_LOG;

    /**
     * 是否保存请求的参数
     *
     * @return the boolean
     */
    boolean isSaveRequestData() default false;

    /**
     * 是否保存响应的结果
     *
     * @return the boolean
     */
    boolean isSaveResponseData() default false;
}
