/*
 * 文件名：NumberValidator.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： NumberValidator.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-25
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.annotation;

import com.asiainfo.ctms.pub.validator.ValidateDict;

/**
 * Integer校验器.
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
public @interface IntegerV {

    /**
     * Not null.
     * 
     */
    abstract boolean notNull() default false;

    /**
     * Length.
     * 
     */
    abstract int length() default ValidateDict.NOT_LENGTH;

    /**
     * Max.
     * 
     */
    abstract int max() default ValidateDict.NOT_MAX;

    /**
     * Min.
     * 
     */
    abstract int min() default ValidateDict.NOT_MIN;

    /**
     * Enum check.
     * 
     */
    abstract int[] enumCheck() default ValidateDict.NOT_INT_ENUM;

    /**
     * Default v.
     * 
     */
    abstract int defaultV() default ValidateDict.NOT_DEFAULT_INT;

}
