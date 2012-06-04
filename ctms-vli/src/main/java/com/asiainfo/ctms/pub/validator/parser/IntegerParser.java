/*
 * 文件名：IntegerProcessor.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IntegerProcessor.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-29
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.parser;

import java.lang.annotation.Annotation;

import com.asiainfo.ctms.pub.validator.AbstractValidator;
import com.asiainfo.ctms.pub.validator.IntegerValidator;
import com.asiainfo.ctms.pub.validator.annotation.IntegerV;
import com.asiainfo.ctms.pub.validator.intf.IValidator;
import com.asiainfo.ctms.pub.validator.parser.intf.IValidatorParser;

/**
 * Integer 解析器
 * 
 * <pre>
 * </pre>
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-29
 * @since CTMS V100R001C01
 */
public class IntegerParser implements IValidatorParser
{

    /**
     * {@inheritDoc}
     */
    public void flushOrigin(Class<?> elementType, Object origin,
            AbstractValidator validator)
    {
        validator.setOrigin(origin);
    }

    /**
     * {@inheritDoc}
     */
    public IValidator parser(Annotation ann, Class<?> elementType,
            String originName)
    {

        if (ann == null || ann.annotationType() != IntegerV.class)
        {
            return null;
        }

        IntegerValidator validator = null;

        IntegerV annInteger = (IntegerV) ann;

        validator = new IntegerValidator();
        validator.setOriginName(originName);
        validator.setOriginType(elementType);
        validator.setEunmValue(annInteger.enumCheck());
        validator.setLength(annInteger.length());
        validator.setMax(annInteger.max());
        validator.setMin(annInteger.min());
        validator.setNotNull(annInteger.notNull());
        validator.setDefalutV(annInteger.defaultV());

        return validator;
    }
}
