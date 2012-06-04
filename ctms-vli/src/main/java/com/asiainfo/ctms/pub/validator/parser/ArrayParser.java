/*
 * 文件名：ArrayProcessor.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ArrayProcessor.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-30
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.parser;

import java.lang.annotation.Annotation;

import com.asiainfo.ctms.pub.validator.AbstractValidator;
import com.asiainfo.ctms.pub.validator.ArrayValidator;
import com.asiainfo.ctms.pub.validator.annotation.ArrayV;
import com.asiainfo.ctms.pub.validator.annotation.ClassV;
import com.asiainfo.ctms.pub.validator.annotation.CollectionV;
import com.asiainfo.ctms.pub.validator.annotation.CustomV;
import com.asiainfo.ctms.pub.validator.annotation.IntegerV;
import com.asiainfo.ctms.pub.validator.annotation.LongV;
import com.asiainfo.ctms.pub.validator.annotation.MapV;
import com.asiainfo.ctms.pub.validator.annotation.StringV;
import com.asiainfo.ctms.pub.validator.intf.IValidator;
import com.asiainfo.ctms.pub.validator.parser.intf.IValidatorParser;
import com.asiainfo.ctms.pub.validator.util.ValidatorCache;

/**
 * Array 解析器
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-30
 * @since CTMS V100R001C01
 */
public class ArrayParser implements IValidatorParser
{

    /**
     * {@inheritDoc}
     */
    public IValidator parser(Annotation ann, Class<?> elementType,
            String originName)
    {
        if (ann == null || ann.annotationType() != ArrayV.class)
        {
            return null;
        }

        ArrayV annArray = (ArrayV) ann;

        ArrayValidator validator = new ArrayValidator();
        validator.setLength(annArray.length());
        validator.setNotNull(annArray.notNull());
        validator.setOriginName(originName);
        validator.setOriginType(elementType);

        Class<?> clazz = elementType.getComponentType();
        String subOriginName = originName + "[{0}]";

        Class<? extends Annotation> eType = annArray.eType();

        if (eType == Annotation.class)
        {
            return validator;
        }

        IValidatorParser parser = null;
        IValidator subValidator = null;
        Annotation annSub = null;

        if (eType == IntegerV.class)
        {
            annSub = annArray.eachInteger();
        }
        else if (eType == LongV.class)
        {
            annSub = annArray.eachLong();
        }
        else if (eType == StringV.class)
        {
            annSub = annArray.eachString();
        }
        else if (eType == ArrayV.class)
        {
        }
        else if (eType == ClassV.class)
        {
            annSub = annArray.eachClass();
        }
        else if (eType == CollectionV.class)
        {
        }
        else if (eType == CustomV.class)
        {
            annSub = annArray.eachCustom();
        }
        else if (eType == MapV.class)
        {

        }

        if (annSub == null)
        {
            return validator;
        }

        validator.setAnn(annSub);

        parser = ValidatorCache.ANN2PARSER.get(annSub.annotationType());
        subValidator = parser.parser(annSub, clazz, subOriginName);
        if (subValidator != null)
        {
            validator.getSubValidators().add((AbstractValidator) subValidator);
        }

        return validator;

    }

    /**
     * {@inheritDoc}
     */
    public void flushOrigin(Class<?> elementType, Object origin,
            AbstractValidator validator)
    {
        validator.setOrigin(origin);
    }
}
