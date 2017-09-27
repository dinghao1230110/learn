package org.hao.learn.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.hao.learn.annotate.Function;
import org.hao.learn.api.FunctionDataBaseService;
import org.hao.learn.api.LogService;
import org.hao.learn.person.domain.FunctionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 作业:
 * 日志插入当前时间和当前用户
 */
@Aspect
@Configuration
public class LogAspect {

    @Autowired
    LogService                            logService;
    @Autowired
    FunctionDataBaseService<FunctionInfo> functionService;

    @Around("execution(* org.hao.learn..*Controller.*(..))")
    public Object writeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //region 获取拦截的方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method          targetMethod    = methodSignature.getMethod();
        //获取方法参数的值
        Object[] args = joinPoint.getArgs();

        Annotation[] annotations = targetMethod.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i] instanceof Function) {
                Function     function     = (Function) annotations[i];
                FunctionInfo functionInfo = functionService.queryFunctionById(function.value());

                try {
                    Object obj = joinPoint.proceed();
                    logService.addSuccessLog("调用功能", args, functionInfo.getName());
                    return obj;
                } catch (Throwable throwable) {
                    logService.addFailureLog("调用功能", args, functionInfo.getName());
                    throw throwable;
                }
            }
        }

        return joinPoint.proceed();
    }
}
