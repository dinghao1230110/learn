package org.hao.learn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.hao.learn.annotate.Function;
import org.hao.learn.exception.AuthenticationException;
import org.hao.learn.exception.NotLoginException;
import org.hao.learn.person.domain.UserInfo;
import org.hao.learn.person.service.FunctionServiceImpl;
import org.hao.learn.person.service.RoleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Aspect
@Configuration
public class FunctionAspect {
    private static final Logger logger = LoggerFactory.getLogger(FunctionAspect.class);

    @Autowired
    HttpSession         httpSession;
    @Autowired
    RoleServiceImpl     roleService;
    @Autowired
    FunctionServiceImpl functionService;


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

        Annotation[] annotations = targetMethod.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i] instanceof Function) {
                Function function = (Function) annotations[i];

                //获取当前登录用户
                if (httpSession.getAttribute("userInfo") == null) {
                    throw new NotLoginException();
                }
                logger.info(httpSession.getAttribute("userInfo").toString());

                //读取当前用户的角色
                UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
                long     roleId   = roleService.queryUserRole(userInfo.getId());

                //读取当前角色的功能
                List<Long> functionIds  = functionService.queryFunction(roleId);
                String     functionName = functionService.queryFunctionName(function.value());
                for (Long functionId : functionIds) {
                    //判断当前角色持有的功能是否包含function.value()
                    if (function.value() == (functionId)) {

                    } else {
                        //如果不是抛出AuthenticationException异常
                        throw new AuthenticationException("您没有访问" + functionName + "的权限");
                    }
                }
                logger.info(String.valueOf(function.value()));
            }
        }
    }
}
