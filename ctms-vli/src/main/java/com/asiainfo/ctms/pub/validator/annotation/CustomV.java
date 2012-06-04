/*
 * 文件名：CustomValidator.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CustomValidator.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-26
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.annotation;

import java.lang.annotation.Inherited;

import com.asiainfo.ctms.pub.validator.AbstractValidator;

/**
 * 自定义校验类
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-26
 * @since CTMS V100R001C01
 */
@java.lang.annotation.Target(value = {
        java.lang.annotation.ElementType.PARAMETER,
        java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Inherited
@Constraint
public @interface CustomV {

    /**
     * Not null.
     * 
     */
    abstract boolean notNull() default false;

    /**
     * Clazz.
     * 
     */
    abstract Class<? extends AbstractValidator> clazz();

}
