/*
 * 文件名：IValidatorProcessor.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IValidatorProcessor.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-29
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.parser.intf;

import java.lang.annotation.Annotation;

import com.asiainfo.ctms.pub.validator.AbstractValidator;
import com.asiainfo.ctms.pub.validator.intf.IValidator;

/**
 * 校验器接口
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-29
 * @since CTMS V100R001C01
 */
public interface IValidatorParser
{
    
    /**
     * Parser.
     *
     * @param ann the ann
     * @param elementType the element type
     * @param originName the origin name
     * @return the i validator
     */
    public IValidator parser(Annotation ann, Class<?> elementType,
            String originName);

    /**
     * Flush origin.
     *
     * @param elementType the element type
     * @param origin the origin
     * @param validator the validator
     */
    public void flushOrigin(Class<?> elementType, Object origin,
            AbstractValidator validator);
}
