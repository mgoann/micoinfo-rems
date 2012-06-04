/*
 * 文件名：DefaultValidator.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： DefaultValidator.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-26
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.asiainfo.ctms.pub.validator.intf.IValidator;

/**
 * 校验框架
 * 
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-26
 * @since CTMS V100R001C01
 */
public abstract class AbstractValidator implements IValidator
{

    private Object origin;

    private String originName;

    private Class<? extends Object> originType;

    private final List<AbstractValidator> subValidators = new ArrayList<AbstractValidator>();

    private boolean notNull;

    /**
     * 获取notNull
     * 
     * @return 返回notNull
     */
    public boolean isNotNull()
    {
        return notNull;
    }

    /**
     * 设置notNull
     * 
     * @param notNull
     *            要设置的notNull
     */
    public void setNotNull(boolean notNull)
    {
        this.notNull = notNull;
    }

    /**
     * 获取validators
     * 
     * @return 返回validators
     */
    public List<AbstractValidator> getSubValidators()
    {
        return subValidators;
    }

    /**
     * 获取originType
     * 
     * @return 返回originType
     */
    public Class<? extends Object> getOriginType()
    {
        return originType;
    }

    /**
     * 设置originType
     * 
     * @param originType
     *            要设置的originType
     */
    public void setOriginType(Class<? extends Object> originType)
    {
        this.originType = originType;
    }

    /**
     * 获取origin
     * 
     * @return 返回origin
     */
    public Object getOrigin()
    {
        return origin;
    }

    /**
     * 获取originName
     * 
     * @return 返回originName
     */
    public String getOriginName()
    {
        return originName;
    }

    /**
     * 设置origin
     * 
     * @param origin
     *            要设置的origin
     */
    public void setOrigin(Object origin)
    {
        this.origin = origin;
    }

    /**
     * 设置originName
     * 
     * @param originName
     *            要设置的originName
     */
    public void setOriginName(String originName)
    {
        this.originName = originName;
    }

    /**
     * {@inheritDoc}
     */
    public abstract void validate();

    protected void notNull()
    {
        throw new ValidateException(
                new ValidateResult(ValidateDict.ReltCode.CAN_NOT_BE_NULL,
                        MessageFormat.format(
                                ValidateDict.ReltDesc.CAN_NOT_BE_NULL,
                                this.originName)));
    }

    protected void tooLength(String expectedLength, String actLength)
    {
        throw new ValidateException(new ValidateResult(
                ValidateDict.ReltCode.VALIDATION_FAILS, MessageFormat
                        .format(ValidateDict.ReltDesc.VALIDATION_FAILS,
                                this.originName), MessageFormat.format(
                        ValidateDict.TOO_LENGTH, expectedLength, actLength)));
    }

    protected void tooMax(String max, String value)
    {
        throw new ValidateException(new ValidateResult(
                ValidateDict.ReltCode.VALIDATION_FAILS, MessageFormat
                        .format(ValidateDict.ReltDesc.VALIDATION_FAILS,
                                this.originName), MessageFormat.format(
                        ValidateDict.TOO_MAX, max, value)));
    }

    protected void tooMin(String min, String value)
    {
        throw new ValidateException(new ValidateResult(
                ValidateDict.ReltCode.VALIDATION_FAILS, MessageFormat
                        .format(ValidateDict.ReltDesc.VALIDATION_FAILS,
                                this.originName), MessageFormat.format(
                        ValidateDict.TOO_MAX, min, value)));
    }

    protected void enumCheck(String enumCheck, Object value)
    {
        throw new ValidateException(new ValidateResult(
                ValidateDict.ReltCode.VALIDATION_FAILS, MessageFormat
                        .format(ValidateDict.ReltDesc.VALIDATION_FAILS,
                                this.originName), MessageFormat.format(
                        ValidateDict.ENUM_CHECK, enumCheck, value.toString())));
    }

    protected void regxCheck(String regx, Object value)
    {
        throw new ValidateException(new ValidateResult(
                ValidateDict.ReltCode.VALIDATION_FAILS, MessageFormat
                        .format(ValidateDict.ReltDesc.VALIDATION_FAILS,
                                this.originName), MessageFormat
                        .format(ValidateDict.PATTERN_VALI_FAILD, regx, value
                                .toString())));
    }

    protected void callSubValidator()
    {
        for (IValidator validator : subValidators)
        {
            validator.validate();
        }
    }

}
