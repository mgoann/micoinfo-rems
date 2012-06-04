/*
 * 文件名：ClassProcessor.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ClassProcessor.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-30
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.parser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import com.asiainfo.ctms.pub.validator.AbstractValidator;
import com.asiainfo.ctms.pub.validator.ClassValidator;
import com.asiainfo.ctms.pub.validator.ValidateException;
import com.asiainfo.ctms.pub.validator.annotation.ClassV;
import com.asiainfo.ctms.pub.validator.intf.IValidator;
import com.asiainfo.ctms.pub.validator.parser.intf.IValidatorParser;
import com.asiainfo.ctms.pub.validator.util.ValidatorCache;

/**
 * 类解析器。
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-30
 * @since CTMS V100R001C01
 */
public class ClassParser implements IValidatorParser
{

    /**
     * {@inheritDoc}
     */
    public void flushOrigin(Class<?> elementType, Object origin,
            AbstractValidator validator)
    {
        validator.setOrigin(origin);

        if (origin == null)
        {
            return;
        }

        List<AbstractValidator> subValidators = validator.getSubValidators();

        for (AbstractValidator subValidator : subValidators)
        {
            IValidatorParser parser = ValidatorCache.VALIDATOR2PARSER
                    .get(subValidator.getClass());
            try
            {
                Field field = origin.getClass().getDeclaredField(
                        subValidator.getOriginName().split("\\.")[1]);

                field.setAccessible(true);
                parser.flushOrigin(elementType.getComponentType(), field
                        .get(origin), subValidator);
            }
            catch (IllegalArgumentException e)
            {
                throw new ValidateException(e);

            }
            catch (SecurityException e)
            {
                throw new ValidateException(e);
            }
            catch (IllegalAccessException e)
            {
                throw new ValidateException(e);
            }
            catch (NoSuchFieldException e)
            {
                throw new ValidateException(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public IValidator parser(Annotation ann, Class<?> elementType,
            String originName)
    {
        if (ann == null || ann.annotationType() != ClassV.class)
        {
            return null;
        }

        ClassV annClass = (ClassV) ann;

        elementType = annClass.clazz();
        ClassValidator validator = new ClassValidator();
        validator.setNotNull(annClass.notNull());
        validator.setOriginName(originName);
        validator.setOriginType(elementType);

        String subOriginName = null;

        Field[] fields = elementType.getDeclaredFields();

        IValidatorParser parser = null;
        IValidator subValidator = null;
        String fieldClassName = elementType.getSimpleName();

        for (Field field : fields)
        {
            Annotation[] anns = field.getAnnotations();
            Class<?> clazz = field.getDeclaringClass();
            subOriginName = fieldClassName + '.' + field.getName();
            for (Annotation annField : anns)
            {
                if (ValidatorCache.ANN2VALIDATE.containsKey(annField
                        .annotationType()))
                {
                    parser = ValidatorCache.ANN2PARSER.get(annField
                            .annotationType());
                    subValidator = parser
                            .parser(annField, clazz, subOriginName);
                    if (subValidator != null)
                    {
                        validator.getSubValidators().add(
                                (AbstractValidator) subValidator);
                    }
                }
            }
        }

        return validator;
    }
}
