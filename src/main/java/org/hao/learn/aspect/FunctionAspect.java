package org.hao.learn.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.hao.learn.annotate.Function;
import org.hao.learn.api.FunctionDataBaseService;
import org.hao.learn.api.LogService;
import org.hao.learn.exception.AuthenticationException;
import org.hao.learn.exception.NotLoginException;
import org.hao.learn.person.domain.FunctionInfo;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.utils.CommonUtil;
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
    @Autowired
    LogService                            logService;


    /**
     * 在controller中所有方法执行前验证数据
     *
     * @param joinPoint
     */
    @Before("execution(* org.hao.learn..*Controller.*(..))")
    public void valid(JoinPoint joinPoint) throws NoSuchMethodException, JsonProcessingException {
        //region 获取拦截的方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method          targetMethod    = methodSignature.getMethod();
        //从 session 缓存中取出当前登录用户持有的功能
        Object functionsObj = httpSession.getAttribute("functions");
        //获取方法参数的值
        Object[] args = joinPoint.getArgs();
        //转换 object 为 Map<Long, FunctionInfo>
        Map<Long, FunctionInfo> functions = (Map<Long, FunctionInfo>) functionsObj;
        UserInfo                userInfo  = CommonUtil.getSessionAttribute(httpSession, "userInfo");

        Annotation[] annotations = targetMethod.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i] instanceof Function) {

                if (userInfo == null) {
                    throw new NotLoginException();
                }

                Function     function     = (Function) annotations[i];
                FunctionInfo functionInfo = functionService.queryFunctionById(function.value());

                if (!functions.containsKey(function.value())) {
                    String errorMsg = "没有访问 " + functionInfo.getName() + " 的权限";
                    logService.addFailureLog("鉴权", args, userInfo.getLoginName() + errorMsg);
                    throw new AuthenticationException(errorMsg);
                }
            }
        }
    }
}
