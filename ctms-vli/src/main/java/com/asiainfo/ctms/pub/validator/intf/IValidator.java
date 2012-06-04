/*
 * 文件名：IValidator.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IValidator.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-25
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.intf;

import java.util.List;

import com.asiainfo.ctms.pub.validator.AbstractValidator;

/**
 * IValidator校验接口
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-25
 * @since CTMS V100R001C01
 */
public interface IValidator
{
    
    /**
     * Validate.
     */
    void validate();

    /**
     * Gets the sub validators.
     *
     * @return the sub validators
     */
    List<AbstractValidator> getSubValidators();
}
