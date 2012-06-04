/*
 * 文件名：CustomProcessor.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CustomProcessor.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-30
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.parser;

import java.lang.annotation.Annotation;

import com.asiainfo.ctms.pub.validator.AbstractValidator;
import com.asiainfo.ctms.pub.validator.CustomValidator;
import com.asiainfo.ctms.pub.validator.ValidateException;
import com.asiainfo.ctms.pub.validator.annotation.CustomV;
import com.asiainfo.ctms.pub.validator.intf.IValidator;
import com.asiainfo.ctms.pub.validator.parser.intf.IValidatorParser;

/**
 * 自定义解析器
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-30
 * @since CTMS V100R001C01
 */
public class CustomParser implements IValidatorParser
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
        if (ann == null || ann.annotationType() != CustomV.class)
        {
            return null;
        }

        CustomV annCustom = (CustomV) ann;

        CustomValidator validator = new CustomValidator();
        validator.setNotNull(annCustom.notNull());
        validator.setOriginName(originName);
        validator.setOriginType(elementType);
        validator.setClazz(annCustom.clazz());

        try
        {
            AbstractValidator subValidator = annCustom.clazz().newInstance();

            if (subValidator != null)
            {
                validator.getSubValidators().add(subValidator);
            }
        }
        catch (InstantiationException e)
        {
            throw new ValidateException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new ValidateException(e);
        }

        return validator;
    }
}
