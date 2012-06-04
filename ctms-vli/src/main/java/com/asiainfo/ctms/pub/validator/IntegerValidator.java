/*
 * 文件名：IntegerValidator.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： IntegerValidator.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-26
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator;

import java.util.Arrays;

import com.asiainfo.ctms.pub.validator.intf.IValidator;

/**
 * IntegerValidator 校验器
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-26
 * @since CTMS V100R001C01
 */
public class IntegerValidator extends AbstractValidator implements IValidator
{

    private int length;

    private int max;

    private int min;

    private int[] eunmValue;

    private int defalutV;

    /**
     * 获取defalutV
     * 
     * @return 返回defalutV
     */
    public int getDefalutV()
    {
        return defalutV;
    }

    /**
     * 设置defalutV
     * 
     * @param defalutV
     *            要设置的defalutV
     */
    public void setDefalutV(int defalutV)
    {
        this.defalutV = defalutV;
    }

    /**
     * 获取eunmValue
     * 
     * @return 返回eunmValue
     */
    public int[] getEunmValue()
    {
        return eunmValue;
    }

    /**
     * 设置eunmValue
     * 
     * @param eunmValue
     *            要设置的eunmValue
     */
    public void setEunmValue(int[] eunmValue)
    {
        this.eunmValue = eunmValue;
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
     * 获取max
     * 
     * @return 返回max
     */
    public int getMax()
    {
        return max;
    }

    /**
     * 获取min
     * 
     * @return 返回min
     */
    public int getMin()
    {
        return min;
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
     * 设置max
     * 
     * @param max
     *            要设置的max
     */
    public void setMax(int max)
    {
        this.max = max;
    }

    /**
     * 设置min
     * 
     * @param min
     *            要设置的min
     */
    public void setMin(int min)
    {
        this.min = min;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate()
    {

        if (this.getDefalutV() != ValidateDict.NOT_DEFAULT_INT)
        {
            super.setOrigin(this.getDefalutV());
            return;
        }

        Integer origin = (Integer) super.getOrigin();
        if (super.isNotNull() && origin == null)
        {
            notNull();
        }

        if (origin == null)
        {
            return;
        }

        int valueLength = String.valueOf(origin).length();

        if (this.length != ValidateDict.NOT_LENGTH && valueLength > this.length)
        {
            super.tooLength(String.valueOf(this.length), String
                    .valueOf(valueLength));
        }

        if (this.max != ValidateDict.NOT_MAX && origin > this.max)
        {
            super.tooMax(String.valueOf(this.max), String.valueOf(origin));
        }

        if (this.min != ValidateDict.NOT_MIN && origin < this.min)
        {
            super.tooMin(String.valueOf(this.min), String.valueOf(origin));
        }

        if (this.eunmValue[0] != ValidateDict.NOT_INT_ENUM
                && Arrays.binarySearch(this.eunmValue, origin) <= -1)
        {
            super.enumCheck(Arrays.toString(this.eunmValue), origin);
        }

    }
}
