/*
 * 文件名：ValidateException.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ValidateException.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-26
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator;

/**
 * 该异常用于返回对象校验结果
 * <p>
 * 该异常用于返回对象校验结果，如果校验通过不抛出异常，如果没有通过抛出ValidateException异常，
 * 并在ValidateResult对象中给出具体出错原因
 * <p>
 * 
 * <pre>
 * </pre>
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-26
 * @since CTMS V100R001C01
 */
public class ValidateException extends RuntimeException
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6649581766215159702L;

    private ValidateResult result;

    /**
     * 构造函数。
     * 
     */
    public ValidateException()
    {
        super();
    }

    /**
     * 构造函数。
     * 
     * @param result
     *            校验结果
     */
    public ValidateException(ValidateResult result)
    {
        super();
        this.result = result;

    }

    /**
     * 构造函数。
     * 
     * @param cause
     */
    public ValidateException(Throwable cause)
    {
        super(cause);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized Throwable fillInStackTrace()
    {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage()
    {
        if (result != null)
        {
            return this.result.toString();
        }
        return super.getMessage();
    }

    /**
     * 获取result
     * 
     * @return 返回result
     */
    public ValidateResult getResult()
    {
        return result;
    }

    /**
     * 设置result
     * 
     * @param result
     *            要设置的result
     */
    public void setResult(ValidateResult result)
    {
        this.result = result;
    }

}
