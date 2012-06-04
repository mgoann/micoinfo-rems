/*
 * 文件名：ValidatorAOP.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ValidatorAOP.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-30
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import com.asiainfo.ctms.pub.validator.parser.ValidatorParser;

/**
 * ValidatorAOP类
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-30
 * @since CTMS V100R001C01
 */
public class ValidatorAOP
{

    public void doBefore(JoinPoint jp)
    {

        Signature signature = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        ValidatorParser.validate(method, jp.getArgs(), jp.getTarget());
    }
}
