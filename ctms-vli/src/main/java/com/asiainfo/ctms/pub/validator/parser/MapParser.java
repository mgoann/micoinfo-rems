/*
 * 文件名：MapProcessor.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MapProcessor.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-30
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.parser;

import java.lang.annotation.Annotation;

import com.asiainfo.ctms.pub.validator.AbstractValidator;
import com.asiainfo.ctms.pub.validator.intf.IValidator;
import com.asiainfo.ctms.pub.validator.parser.intf.IValidatorParser;

/**
 * Map解析器
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-30
 * @since CTMS V100R001C01
 */
public class MapParser implements IValidatorParser
{

    /**
     * {@inheritDoc}
     */
    public void flushOrigin(Class<?> elementType, Object origin,
            AbstractValidator validator)
    {

    }

    /**
     * {@inheritDoc}
     */
    public IValidator parser(Annotation ann, Class<?> elementType,
            String originName)
    {
        return null;
    }

}
