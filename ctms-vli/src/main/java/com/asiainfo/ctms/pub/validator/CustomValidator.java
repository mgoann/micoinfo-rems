/*
 * 文件名：CustomValidate.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CustomValidate.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-29
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator;

import com.asiainfo.ctms.pub.validator.intf.IValidator;

/**
 * 自定义校验器
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-29
 * @since CTMS V100R001C01
 */
public class CustomValidator extends AbstractValidator implements IValidator
{

    private Class<? extends AbstractValidator> clazz;

    /**
     * 获取clazz
     * 
     * @return 返回clazz
     */
    public Class<? extends AbstractValidator> getClazz()
    {
        return clazz;
    }

    /**
     * 设置clazz
     * 
     * @param clazz
     *            要设置的clazz
     */
    public void setClazz(Class<? extends AbstractValidator> clazz)
    {
        this.clazz = clazz;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate()
    {
        if (super.isNotNull() && super.getOrigin() == null)
        {
            super.notNull();
        }

        if (super.getOrigin() == null)
        {
            return;
        }

        try
        {
            AbstractValidator validator = this.clazz.newInstance();
            validator.setOrigin(super.getOrigin());
            validator.setNotNull(super.isNotNull());
            validator.setOriginName(super.getOriginName());
            validator.setOriginType(super.getOriginType());
            validator.validate();
        }
        catch (InstantiationException e)
        {
            throw new ValidateException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new ValidateException(e);
        }
    }
}
