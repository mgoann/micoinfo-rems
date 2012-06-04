/*
 * 文件名：ValidatorParser.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ValidatorParser.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-26
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.parser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import com.asiainfo.ctms.pub.validator.AbstractValidator;
import com.asiainfo.ctms.pub.validator.MethodValidator;
import com.asiainfo.ctms.pub.validator.ValidateException;
import com.asiainfo.ctms.pub.validator.intf.IValidator;
import com.asiainfo.ctms.pub.validator.parser.intf.IValidatorParser;
import com.asiainfo.ctms.pub.validator.util.ValidatorCache;

/**
 * Validator 校验解析器
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-26
 * @since CTMS V100R001C01
 */
public class ValidatorParser
{

    public static void validate(Method method, Object[] args,
            Object objOriginal2)
    {

        MethodValidator validator = null;
        Class<?>[] paramTypes = method.getParameterTypes();
        if (ValidatorCache.METHOD2VALIDATOR.containsKey(method))
        {
            validator = ValidatorCache.METHOD2VALIDATOR.get(method);
        }
        else
        {
            Method reallyMethod = null;

            validator = new MethodValidator();

            try
            {
                reallyMethod = objOriginal2.getClass().getMethod(
                        method.getName(), method.getParameterTypes());

                Annotation[][] anns = reallyMethod.getParameterAnnotations();

                String originName = objOriginal2.getClass().getSimpleName()
                        + '.' + method.getName() + ".param[";

                for (int i = 0; i < anns.length; i++)
                {
                    Annotation[] paramsAnn = anns[i];
                    for (Annotation ann : paramsAnn)
                    {
                        if (ValidatorCache.ANN2VALIDATE.containsKey(ann
                                .annotationType()))
                        {
                            IValidatorParser parser = ValidatorCache.ANN2PARSER
                                    .get(ann.annotationType());

                            IValidator subValidator = parser.parser(ann,
                                    paramTypes[i], originName + i + ']');

                            validator.addParamType(paramTypes[i]);
                            validator.addParamIndex(i);

                            if (subValidator != null)
                            {
                                validator.getSubValidators().add(
                                        (AbstractValidator) subValidator);
                            }

                        }
                    }
                }

            }
            catch (SecurityException e)
            {
                throw new ValidateException(e);
            }
            catch (NoSuchMethodException e)
            {
                throw new ValidateException(e);
            }

            ValidatorCache.METHOD2VALIDATOR.put(method, validator);
        }

        flushOrigin(args, validator, paramTypes);

    }

    public static void flushOrigin(Object[] args, MethodValidator validator,
            Class<?>[] paramTypes)
    {
        List<AbstractValidator> subValidators = validator.getSubValidators();

        int index = 0;
        for (AbstractValidator subValidator : subValidators)
        {
            IValidatorParser parser = ValidatorCache.VALIDATOR2PARSER
                    .get(subValidator.getClass());

            parser.flushOrigin(validator.getParamTypes().get(index),
                    args[validator.getParamIndex().get(index)], subValidator);
            index++;
        }

        validator.validate();
    }
}
