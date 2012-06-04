/*
 * 文件名：ArrayUtil.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ArrayUtil.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-29
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator.util;

/**
 * ArrayUtil工具类
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-29
 * @since CTMS V100R001C01
 */
public class ArrayUtil
{
    public static String toString(Object[] objs)
    {
        StringBuilder sb = new StringBuilder();
        for (Object object : objs)
        {
            sb.append(object.toString());
            sb.append(',');
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static Object[] cast(int[] arr)
    {
        Object[] objs = new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            objs[i] = Integer.valueOf(arr[i]);
        }

        return objs;
    }

    public static Object[] cast(Object obj)
    {
        Class<?> objClazz = obj.getClass();
        if (objClazz.isArray())
        {
            Class<?> arrCompType = objClazz.getComponentType();
            if (arrCompType.isPrimitive())
            {
                if (arrCompType == int.class)
                {
                    int[] ints = (int[]) obj;

                    Integer[] integer = new Integer[ints.length];

                    int index = 0;
                    for (int aint : ints)
                    {
                        integer[index++] = aint;
                    }

                    return integer;
                }
                else if (arrCompType == long.class)
                {
                    long[] longs = (long[]) obj;

                    Long[] longsWrap = new Long[longs.length];

                    int index = 0;
                    for (long along : longs)
                    {
                        longsWrap[index++] = along;
                    }

                    return longsWrap;
                }
            }
            return (Object[]) obj;
        }
        return null;
    }
}
