/*
 * 文件名：ValidatorConstants.java
 * 版权：Copyright 2006-2011 AsiaInfo Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ValidatorConstants.java
 * 修改人：齐鹏飞
 * 修改时间：2011-8-25
 * 修改内容：新增
 */
package com.asiainfo.ctms.pub.validator;

/**
 * 校验结果字典常量
 * 
 * 
 * @author 齐鹏飞
 * @version CTMS V100R001 2011-8-25
 * @since CTMS V100R001C01
 */
public interface ValidateDict
{
    String NOT_PATTERN = "NOT_PATTERN";

    int NOT_LENGTH = -1;

    int NOT_MIN = Integer.MIN_VALUE;

    int NOT_MAX = Integer.MAX_VALUE;

    int NOT_INT_ENUM = -435435;

    long NOT_LONG_ENUM = -8980984328L;

    String NOT_STRING_ENUM = "NOT_STRING_ENUM";

    String TOO_LENGTH = "too long to expect length is {0}, but actually {1}.";

    String PATTERN_VALI_FAILD = "regx validate failded, regx is {0}, value is {1}.";

    String TOO_MAX = "value is too max, max value is {0}, value is {1}.";

    String TOO_MIN = "value is too min, min value is {0}, value is {1}.";

    String ENUM_CHECK = "enum value is error, enum check is {0}, value is {1}.";

    String NOT_DEFAULT = "NOT_DEFAULT";

    long NOT_DEFAULT_LONG = -8980984328L;

    int NOT_DEFAULT_INT = -435435;

    public interface ReltCode
    {

        /**
         * 操作成功
         */
        String SUCESS_CODE = "200001";

        /**
         * 创建资源成功
         */
        String RESOURCE_CREATED = "201000";

        /**
         * 用户没有权限进行该操作
         */
        String LOGIN_FAIL_CODE = "403001";

        /**
         * 违反系统唯一性
         */
        String FIELD_UNIQUE = "403004";

        /**
         * 组织ID错误
         */
        String ORGID_FAILD = "403005";

        /**
         * 角色ID错误
         */
        String ROLEID_FAILD = "403005";

        /**
         * 登陆账号不存在
         */
        String NO_ACCOUNT = "401003";

        /**
         * 用户状态异常
         */
        String USER_STATUS_ERROR = "401005";

        /**
         * 非Boss账号
         */
        String NOT_BOSS_UNIQUE = "403009";

        /**
         * 非OA账号
         */
        String NOT_OA_UNIQUE = "403010";

        /**
         * 字段取值不能为空
         */
        String CAN_NOT_BE_NULL = "403002";

        /**
         * 其他校验失败
         */
        String VALIDATION_FAILS = "403005";

        /**
         * 操作的资源不存在
         */
        String RESOURCE_NOT_FOUND = "404001";

        /**
         * 服务器内部错误
         */
        String SERVER_INTERNAL_ERROR = "500001";
    }

    public interface ReltDesc
    {

        /**
         * 操作成功
         */
        String SUCESS_DESC = "Opertion Sucess";

        /**
         * 登陆失败
         */
        String LOGIN_FAIL_DESC = "Login Failed";

        /**
         * 创建资源成功
         */
        String RESOURCE_CREATED = "Resource created";

        /**
         * 唯一性校验
         */
        String FIELD_UNIQUE = "login name field must be unique";

        /**
         * 组织ID校验错误
         */
        String ORG_ID_FAILS = "org_id field validation fails";

        /**
         * 角色ID校验错误
         */
        String ROLE_ID_FAILS = "role_id field validation fails";

        /**
         * 登陆账号不存在
         */
        String NO_ACCOUNT = "No or invalid login name";

        /**
         * 用户状态异常
         */
        String USER_STATUS_ERROR = "User status error";

        /**
         * 非Boss账号
         */
        String NOT_BOSS_UNIQUE = "Is not BOSS account";

        /**
         * 非OA账号
         */
        String NOT_OA_UNIQUE = "Is not OA account";

        /**
         * 字段取值不能为空
         */
        String CAN_NOT_BE_NULL = "{0} field not allowed to be empty";

        /**
         * 字段校验不通过
         */
        String VALIDATION_FAILS = "{0} field validation fails";

        /**
         * 操作的资源不存在
         */
        String RESOURCE_NOT_FOUND = "Resource not found";

        /**
         * 服务器内部错误
         */
        String SERVER_INTERNAL_ERROR = "Server internal error";

    }

}
