/*
 * 文件名：MethodValidate.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： MethodValidate.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-29
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator;

import java.util.ArrayList;
import java.util.List;

import com.asiainfo.ctms.pub.validator.intf.IValidator;

/**
 * 方法校验器.
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-29
 * @since CTMS V100R001C01
 */
public class MethodValidator extends AbstractValidator implements IValidator
{

    /** The param types. */
    private List<Class<?>> paramTypes = new ArrayList<Class<?>>();

    /** The param index. */
    private List<Integer> paramIndex = new ArrayList<Integer>();

    /**
     * Gets the param types.
     * 
     * @return the param types
     */
    public List<Class<?>> getParamTypes()
    {
        return this.paramTypes;
    }

    /**
     * Gets the param index.
     * 
     * @return the param index
     */
    public List<Integer> getParamIndex()
    {
        return this.paramIndex;
    }

    /**
     * Adds the param type.
     * 
     * @param clazz
     *            the clazz
     */
    public void addParamType(Class<?> clazz)
    {
        paramTypes.add(clazz);
    }

    /**
     * Adds the param index.
     * 
     * @param index
     *            the index
     */
    public void addParamIndex(int index)
    {
        paramIndex.add(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate()
    {
        super.callSubValidator();
    }

}
