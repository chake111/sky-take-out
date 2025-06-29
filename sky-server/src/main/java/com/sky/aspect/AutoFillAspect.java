package com.sky.aspect;

import com.sky.annotation.AutoFill;
import com.sky.constant.AutoFillConstant;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import static com.sky.context.BaseContext.getCurrentId;
import static java.time.LocalDateTime.now;

/**
 * @author chake
 */ /*
 * ClassName: AutoFillAspect
 * Package: com.sky.aspect
 * Description:
 * @Author: chake
 * @Create 2025/6/29 10:46
 * @Version 1.0
 */
@Slf4j
@Component
@Aspect
public class AutoFillAspect {
    /**
     * 自动填充切入点
     */
    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void autoFillPointcut() {}

    /**
     * 前置通知
     */
    @Before("autoFillPointcut()")
    public void autoFill(JoinPoint jp) {
        log.info("开始执行自动填充数据...");

        MethodSignature signature = (MethodSignature) jp.getSignature();
        AutoFill annotation = signature.getMethod().getAnnotation(AutoFill.class);
        OperationType operationType = annotation.value();

        Object[] args = jp.getArgs();

        if (args == null || args.length == 0) {
            return;
        }

        Object entity = args[0];


        if (operationType == OperationType.UPDATE) {
            try {
                Method setUpdateTime = entity.getClass().getMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);
                setUpdateTime.invoke(entity, now());
                setUpdateUser.invoke(entity, getCurrentId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (operationType == OperationType.INSERT) {
            try {
                Method setUpdateTime = entity.getClass().getMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);
                Method setCreateTime = entity.getClass().getMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
                Method setCreateUser = entity.getClass().getMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
                setUpdateTime.invoke(entity, now());
                setUpdateUser.invoke(entity, getCurrentId());
                setCreateTime.invoke(entity, now());
                setCreateUser.invoke(entity, getCurrentId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
