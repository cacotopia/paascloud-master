package com.supos.cloud.core.annotation;

import java.lang.annotation.*;

/**
 * 配合 SqlLogInterceptor 对指定方法 禁止打印SQL到控制台
 *
 * @author walkman
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface NotDisplaySql {
}
