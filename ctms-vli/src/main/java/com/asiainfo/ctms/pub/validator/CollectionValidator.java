/*
 * 文件名：CollectionValidate.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： CollectionValidate.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-29
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.asiainfo.ctms.pub.validator.intf.IValidator;
import com.asiainfo.ctms.pub.validator.parser.intf.IValidatorParser;
import com.asiainfo.ctms.pub.validator.util.ValidatorCache;

/**
 * 集合校验器。
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-29
 * @since CTMS V100R001C01
 */
public class CollectionValidator extends AbstractValidator implements
        IValidator
{
    private int length;

    private Annotation ann;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void callSubValidator()
    {
        AbstractValidator subValidator = this.getSubValidators().get(0);

        if (this.getOrigin() == null
                || !(this.getOrigin() instanceof Collection<?>))
        {
            return;
        }

        Collection<?> colls = (Collection<?>) this.getOrigin();

        if (colls.isEmpty())
        {
            return;
        }

        Class<?> clazz = colls.iterator().next().getClass();

        Iterator<?> iter = colls.iterator();
        while (iter.hasNext())
        {
            IValidatorParser parser = ValidatorCache.VALIDATOR2PARSER
                    .get(subValidator.getClass());
            parser.flushOrigin(clazz, iter.next(), subValidator);
            subValidator.validate();
        }
    }

    /**
     * 获取ann
     * 
     * @return 返回ann
     */
    public Annotation getAnn()
    {
        return ann;
    }

    /**
     * 设置ann
     * 
     * @param ann
     *            要设置的ann
     */
    public void setAnn(Annotation ann)
    {
        this.ann = ann;
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
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void validate()
    {
        if (super.isNotNull() && super.getOrigin() == null)
        {
            super.notNull();
        }

        Collection colls = (Collection) super.getOrigin();

        if (super.isNotNull() && (colls == null || colls.isEmpty()))
        {
            super.notNull();
        }

        if (colls == null || colls.isEmpty())
        {
            return;
        }

        if (this.getLength() != ValidateDict.NOT_LENGTH
                && colls.size() > this.getLength())
        {
            super.tooLength(String.valueOf(this.getLength()), String
                    .valueOf(colls.size()));
        }

        for (Object obj : colls)
        {
            List<AbstractValidator> subValidators = super.getSubValidators();
            for (AbstractValidator validator : subValidators)
            {
                IValidatorParser parser = ValidatorCache.VALIDATOR2PARSER
                        .get(validator.getClass());

                parser.flushOrigin(this.getOriginType(), obj, validator);
            }
            super.callSubValidator();
        }

    }

}
