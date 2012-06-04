/*
 * 文件名：ClassValidator.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ClassValidator.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-26
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator;

import com.asiainfo.ctms.pub.validator.intf.IValidator;

/**
 * 类校验器
 * 
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-26
 * @since CTMS V100R001C01
 */
public class ClassValidator extends AbstractValidator implements IValidator
{

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

        this.callSubValidator();

    }

}
