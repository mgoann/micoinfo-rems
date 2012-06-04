/*
 * 文件名：StringValidator.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： StringValidator.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-25
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.annotation;

import com.asiainfo.ctms.pub.validator.ValidateDict;

/**
 * String类校验器
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-25
 * @since CTMS V100R001C01
 */
@java.lang.annotation.Target(value = {
        java.lang.annotation.ElementType.PARAMETER,
        java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Constraint
public @interface StringV {
    abstract boolean notNull() default false;

    abstract int length() default ValidateDict.NOT_LENGTH;

    abstract String pattern() default ValidateDict.NOT_PATTERN;

    abstract String[] enumCheck() default ValidateDict.NOT_STRING_ENUM;

    abstract String defaultV() default ValidateDict.NOT_DEFAULT;
}
