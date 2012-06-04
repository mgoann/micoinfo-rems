/*
 * 文件名：StringProcessor.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： StringProcessor.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-29
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.parser;

import java.lang.annotation.Annotation;

import com.asiainfo.ctms.pub.validator.AbstractValidator;
import com.asiainfo.ctms.pub.validator.StringValidator;
import com.asiainfo.ctms.pub.validator.annotation.StringV;
import com.asiainfo.ctms.pub.validator.intf.IValidator;
import com.asiainfo.ctms.pub.validator.parser.intf.IValidatorParser;

/**
 * String 解析器
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-29
 * @since CTMS V100R001C01
 */
public class StringParser implements IValidatorParser
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

        if (ann == null || ann.annotationType() != StringV.class)
        {
            return null;
        }
        StringValidator validator = null;

        StringV annString = (StringV) ann;

        validator = new StringValidator();
        validator.setOriginName(originName);
        validator.setOriginType(elementType);
        validator.setEnumValue(annString.enumCheck());
        validator.setPattern(annString.pattern());
        validator.setLength(annString.length());
        validator.setNotNull(annString.notNull());
        validator.setDefaultV(annString.defaultV());

        return validator;
    }

}
