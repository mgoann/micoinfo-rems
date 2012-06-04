/*
 * 文件名：ValidatoResult.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ValidatoResult.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-25
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator;

/**
 * 校验结果
 * <p>
 * 所有的校验结果有以该对象描述校验结果
 * <p>
 * 
 * <pre>
 * </pre>
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-25
 * @since CTMS V100R001C01
 */
public class ValidateResult
{

    /**
     * 失败错误码
     */
    private String resultCode;

    /**
     * 错误描述
     */
    private String resultDesc;

    private String msg;

    /**
     * 构造函数
     * 
     * @param resultCode
     *            返回结果代码
     * @param resultDesc
     *            返回结果描述
     * @param msg
     *            返回消息
     */
    public ValidateResult(String resultCode, String resultDesc, String msg)
    {
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
        this.msg = msg;
    }

    /**
     * 构造函数
     * 
     * @param resultCode
     *            返回结果代码
     * @param resultDesc
     *            返回结果描述
     */
    public ValidateResult(String resultCode, String resultDesc)
    {
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
    }

    /**
     * 获取fieldName
     * 
     * @return 返回fieldName
     */
    public String getMsg()
    {
        return msg;
    }

    /**
     * 设置fieldName
     * 
     * @param fieldName
     *            要设置的fieldName
     */
    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    /**
     * 获取resultCode
     * 
     * @return 返回resultCode
     */
    public String getResultCode()
    {
        return resultCode;
    }

    /**
     * 获取resultDesc
     * 
     * @return 返回resultDesc
     */
    public String getResultDesc()
    {
        return resultDesc;
    }

    /**
     * 设置resultCode
     * 
     * @param resultCode
     *            要设置的resultCode
     */
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }

    /**
     * 设置resultDesc
     * 
     * @param resultDesc
     *            要设置的resultDesc
     */
    public void setResultDesc(String resultDesc)
    {
        this.resultDesc = resultDesc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.resultCode).append(", ");
        sb.append(this.resultDesc).append(", ");
        sb.append(this.msg);
        return sb.toString();
    }
}
