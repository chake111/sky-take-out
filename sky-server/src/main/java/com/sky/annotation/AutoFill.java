package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chake
 */ /*
 * ClassName: AutoFIll
 * Package: com.sky.annotation
 * Description: 自定义注解，用于自动填充数据
 * @Author: chake
 * @Create 2025/6/29 10:36
 * @Version 1.0
 */
@Target(ElementType.METHOD )
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    /** 操作类型：INSERT or UPDATE */
    OperationType value();
}
