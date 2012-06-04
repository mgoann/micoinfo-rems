/*
 * 文件名：StringValidator.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： StringValidator.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-26
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator;

import java.io.UnsupportedEncodingException;

import com.asiainfo.ctms.pub.validator.intf.IValidator;
import com.asiainfo.ctms.pub.validator.util.StringUtils;

/**
 * String 校验类
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-26
 * @since CTMS V100R001C01
 */
public class StringValidator extends AbstractValidator implements IValidator
{
    private int length;

    private String pattern;

    private String[] enumValue;

    private String defaultV;

    /**
     * 获取defaultV
     * 
     * @return 返回defaultV
     */
    public String getDefaultV()
    {
        return defaultV;
    }

    /**
     * 设置defaultV
     * 
     * @param defaultV
     *            要设置的defaultV
     */
    public void setDefaultV(String defaultV)
    {
        this.defaultV = defaultV;
    }

    /**
     * 获取enumValue
     * 
     * @return 返回enumValue
     */
    public String[] getEnumValue()
    {
        return enumValue;
    }

    /**
     * 设置enumValue
     * 
     * @param enumValue
     *            要设置的enumValue
     */
    public void setEnumValue(String[] enumValue)
    {
        this.enumValue = enumValue;
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
     * 获取pattern
     * 
     * @return 返回pattern
     */
    public String getPattern()
    {
        return pattern;
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
     * 设置pattern
     * 
     * @param pattern
     *            要设置的pattern
     */
    public void setPattern(String pattern)
    {
        this.pattern = pattern;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate()
    {

        String origin = (String) super.getOrigin();
        if (super.isNotNull() && StringUtils.isNull(origin))
        {
            super.notNull();
        }
        else if (!StringUtils.isNull(origin))
        {
            if (this.length != ValidateDict.NOT_LENGTH)
            {
                try
                {

                    int valueLength = origin.getBytes("UTF-8").length;
                    if (valueLength > this.length)
                    {
                        super.tooLength(String.valueOf(this.getLength()),
                                String.valueOf(valueLength));
                    }
                }
                catch (UnsupportedEncodingException e)
                {
                    throw new ValidateException(new ValidateResult(
                            ValidateDict.ReltCode.VALIDATION_FAILS,
                            ValidateDict.ReltDesc.VALIDATION_FAILS,
                            "get bytes error"));
                }
            }

            if (!this.pattern.equals(ValidateDict.NOT_PATTERN))
            {
                if (!StringUtils.matcher(origin, this.pattern))
                {
                    super.regxCheck(this.pattern, origin);
                }
            }

        }
    }

}
