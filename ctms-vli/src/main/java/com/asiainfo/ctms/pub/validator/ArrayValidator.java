/*
 * 文件名：ArrayValidate.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ArrayValidate.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-29
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator;

import java.lang.annotation.Annotation;

import com.asiainfo.ctms.pub.validator.intf.IValidator;
import com.asiainfo.ctms.pub.validator.parser.intf.IValidatorParser;
import com.asiainfo.ctms.pub.validator.util.ArrayUtil;
import com.asiainfo.ctms.pub.validator.util.ValidatorCache;

/**
 * DTO校验框架校验ArrayList
 * 
 * <pre>
 * </pre>
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-29
 * @since CTMS V100R001C01
 */
public class ArrayValidator extends AbstractValidator implements IValidator
{

    private Annotation ann;

    private int length;

    /**
     * 获取ann
     * 
     * @return 返回ann
     */
    public Annotation getAnn()
    {
        return ann;
    }

    /**
     * 设置ann
     * 
     * @param ann
     *            要设置的ann
     */
    public void setAnn(Annotation ann)
    {
        this.ann = ann;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void callSubValidator()
    {
        AbstractValidator subValidator = this.getSubValidators().get(0);

        if (this.getOrigin() == null
                || !(this.getOrigin().getClass().isArray()))
        {
            return;
        }

        Object[] objs = ArrayUtil.cast(this.getOrigin());

        if (objs.length == 0)
        {
            return;
        }

        Class<?> clazz = objs.getClass().getComponentType();

        for (Object obj : objs)
        {
            IValidatorParser parser = ValidatorCache.VALIDATOR2PARSER
                    .get(subValidator.getClass());
            parser.flushOrigin(clazz, obj, subValidator);
            subValidator.validate();
        }

    }

    /**
     * 获取length
     * 
     * @return 返回length
     */
    public int getLength()
    {
        return length;
    }

    /**
     * 设置length
     * 
     * @param length
     *            要设置的length
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate()
    {
        if (this.isNotNull() && this.getOrigin() == null)
        {
            this.notNull();
        }

        if (this.getOrigin() == null)
        {
            return;
        }

        Object[] objs = ArrayUtil.cast(this.getOrigin());

        if (this.isNotNull() && objs.length == 0)
        {
            this.notNull();
        }

        if (objs.length == 0)
        {
            return;
        }

        if (this.getLength() != ValidateDict.NOT_LENGTH
                && objs.length > this.getLength())
        {
            this.tooLength(String.valueOf(this.getLength()), String
                    .valueOf(objs.length));
        }

        this.callSubValidator();
    }
}
