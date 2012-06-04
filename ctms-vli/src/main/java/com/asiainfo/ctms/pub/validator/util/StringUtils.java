/*
 * 文件名：StringUtils.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： StringUtils.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-31
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String处理工具
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-31
 * @since CTMS V100R001C01
 */
public class StringUtils
{

    public static boolean isNull(String str)
    {
        return (str == null || str.trim().equals(""));
    }

    /**
     * 
     * 正则表达式验证
     * 
     * @param str
     *            验证字符串
     * @param regex
     *            正则表达式
     * @return boolean
     */
    public static boolean matcher(String str, String regex)
    {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.find();
    }

}
