package org.hao.learn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.hao.learn.annotate.Function;
import org.hao.learn.api.FunctionDataBaseService;
import org.hao.learn.exception.AuthenticationException;
import org.hao.learn.person.domain.FunctionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;

@Aspect
@Configuration
public class FunctionAspect {
    private static final Logger logger = LoggerFactory.getLogger(FunctionAspect.class);

    @Autowired
    HttpSession                           httpSession;
    @Autowired
    FunctionDataBaseService<FunctionInfo> functionService;


    /**
     * 在controller中所有方法执行前验证数据
     *
     * @param joinPoint
     */
    @Before("execution(* org.hao.learn..*Controller.*(..))")
    public void valid(JoinPoint joinPoint) throws NoSuchMethodException {
        //region 获取拦截的方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method          targetMethod    = methodSignature.getMethod();
        //从 session 缓存中取出当前登录用户持有的功能
        Object functionsObj = httpSession.getAttribute("functions");
        //转换 object 为 Map<Long, FunctionInfo>
        Map<Long, FunctionInfo> functions = (Map<Long, FunctionInfo>) functionsObj;

        Annotation[] annotations = targetMethod.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i] instanceof Function) {
                Function     function     = (Function) annotations[i];
                FunctionInfo functionInfo = functionService.queryFunctionById(function.value());

                if (!functions.containsKey(function.value())) {
                    throw new AuthenticationException("您没有访问 " + functionInfo.getName() + " 的权限");
                }
            }
        }
    }
}
