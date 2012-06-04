/*
 * 文件名：LongProcessor.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： LongProcessor.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-30
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.parser;

import java.lang.annotation.Annotation;

import com.asiainfo.ctms.pub.validator.AbstractValidator;
import com.asiainfo.ctms.pub.validator.LongValidator;
import com.asiainfo.ctms.pub.validator.annotation.LongV;
import com.asiainfo.ctms.pub.validator.intf.IValidator;
import com.asiainfo.ctms.pub.validator.parser.intf.IValidatorParser;

/**
 * Long对象解析器
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-30
 * @since CTMS V100R001C01
 */
public class LongParser implements IValidatorParser
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

        if (ann == null || ann.annotationType() != LongV.class)
        {
            return null;
        }

        LongValidator validator = null;

        LongV annLong = (LongV) ann;

        validator = new LongValidator();
        validator.setOriginName(originName);
        validator.setOriginType(elementType);
        validator.setEunmValue(annLong.enumCheck());
        validator.setLength(annLong.length());
        validator.setMax(annLong.max());
        validator.setMin(annLong.min());
        validator.setNotNull(annLong.notNull());
        validator.setDefaultV(annLong.defalutV());

        return validator;
    }

}
