/*
 * 文件名：ValidatorCache.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ValidatorCache.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-29
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.asiainfo.ctms.pub.validator.AbstractValidator;
import com.asiainfo.ctms.pub.validator.ArrayValidator;
import com.asiainfo.ctms.pub.validator.ClassValidator;
import com.asiainfo.ctms.pub.validator.CollectionValidator;
import com.asiainfo.ctms.pub.validator.CustomValidator;
import com.asiainfo.ctms.pub.validator.IntegerValidator;
import com.asiainfo.ctms.pub.validator.LongValidator;
import com.asiainfo.ctms.pub.validator.MapValidator;
import com.asiainfo.ctms.pub.validator.MethodValidator;
import com.asiainfo.ctms.pub.validator.StringValidator;
import com.asiainfo.ctms.pub.validator.annotation.ArrayV;
import com.asiainfo.ctms.pub.validator.annotation.ClassV;
import com.asiainfo.ctms.pub.validator.annotation.CollectionV;
import com.asiainfo.ctms.pub.validator.annotation.CustomV;
import com.asiainfo.ctms.pub.validator.annotation.IntegerV;
import com.asiainfo.ctms.pub.validator.annotation.LongV;
import com.asiainfo.ctms.pub.validator.annotation.MapV;
import com.asiainfo.ctms.pub.validator.annotation.StringV;
import com.asiainfo.ctms.pub.validator.intf.IValidator;
import com.asiainfo.ctms.pub.validator.parser.ArrayParser;
import com.asiainfo.ctms.pub.validator.parser.ClassParser;
import com.asiainfo.ctms.pub.validator.parser.CollectionParser;
import com.asiainfo.ctms.pub.validator.parser.CustomParser;
import com.asiainfo.ctms.pub.validator.parser.IntegerParser;
import com.asiainfo.ctms.pub.validator.parser.LongParser;
import com.asiainfo.ctms.pub.validator.parser.MapParser;
import com.asiainfo.ctms.pub.validator.parser.StringParser;
import com.asiainfo.ctms.pub.validator.parser.intf.IValidatorParser;

/**
 * Validator 缓存
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-29
 * @since CTMS V100R001C01
 */
public final class ValidatorCache
{

    public static final Map<Class<? extends Annotation>, Class<? extends AbstractValidator>> ANN2VALIDATE = new HashMap<Class<? extends Annotation>, Class<? extends AbstractValidator>>();

    public static final Map<Class<? extends Annotation>, IValidatorParser> ANN2PARSER = new HashMap<Class<? extends Annotation>, IValidatorParser>();

    public static final Map<Class<? extends IValidator>, IValidatorParser> VALIDATOR2PARSER = new HashMap<Class<? extends IValidator>, IValidatorParser>();

    public static final HashMap<Method, MethodValidator> METHOD2VALIDATOR = new HashMap<Method, MethodValidator>();

    static
    {
        ANN2VALIDATE.put(IntegerV.class, IntegerValidator.class);
        ANN2VALIDATE.put(StringV.class, StringValidator.class);
        ANN2VALIDATE.put(LongV.class, LongValidator.class);
        ANN2VALIDATE.put(ClassV.class, ClassValidator.class);
        ANN2VALIDATE.put(CollectionV.class, CollectionValidator.class);
        ANN2VALIDATE.put(ArrayV.class, ArrayValidator.class);
        ANN2VALIDATE.put(MapV.class, MapValidator.class);
        ANN2VALIDATE.put(CustomV.class, CustomValidator.class);

    }

    static
    {
        ANN2PARSER.put(IntegerV.class, new IntegerParser());
        ANN2PARSER.put(StringV.class, new StringParser());
        ANN2PARSER.put(LongV.class, new LongParser());
        ANN2PARSER.put(ClassV.class, new ClassParser());
        ANN2PARSER.put(CollectionV.class, new CollectionParser());
        ANN2PARSER.put(ArrayV.class, new ArrayParser());
        ANN2PARSER.put(MapV.class, new MapParser());
        ANN2PARSER.put(CustomV.class, new CustomParser());

    }

    static
    {
        VALIDATOR2PARSER.put(IntegerValidator.class, new IntegerParser());
        VALIDATOR2PARSER.put(StringValidator.class, new StringParser());
        VALIDATOR2PARSER.put(LongValidator.class, new LongParser());
        VALIDATOR2PARSER.put(ClassValidator.class, new ClassParser());
        VALIDATOR2PARSER.put(CollectionValidator.class, new CollectionParser());
        VALIDATOR2PARSER.put(ArrayValidator.class, new ArrayParser());
        VALIDATOR2PARSER.put(MapValidator.class, new MapParser());
        VALIDATOR2PARSER.put(CustomValidator.class, new CustomParser());
    }

}
