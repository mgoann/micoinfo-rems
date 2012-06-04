/*
 * 文件名：ArrayValidator.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ArrayValidator.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-25
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;

import com.asiainfo.ctms.pub.validator.AbstractValidator;
import com.asiainfo.ctms.pub.validator.ValidateDict;

/**
 * 集合校验接口
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-25
 * @since CTMS V100R001C01
 */
@java.lang.annotation.Target(value = {
        java.lang.annotation.ElementType.PARAMETER,
        java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Inherited
@Constraint
public @interface CollectionV {

    abstract boolean notNull() default false;

    abstract int length() default ValidateDict.NOT_LENGTH;

    abstract Class<? extends Annotation> eType() default Annotation.class;

    abstract StringV eachString() default @StringV;

    abstract IntegerV eachInteger() default @IntegerV;

    abstract LongV eachLong() default @LongV;

    abstract ClassV eachClass() default @ClassV;

    abstract CustomV eachCustom() default @CustomV(clazz = AbstractValidator.class);

}
