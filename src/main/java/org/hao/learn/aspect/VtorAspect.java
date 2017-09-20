package org.hao.learn.aspect;

import jodd.vtor.Violation;
import jodd.vtor.Vtor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.hao.learn.exception.VtorException;
import org.hao.learn.vtor.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Configuration
public class VtorAspect {
    private static final Logger logger = LoggerFactory.getLogger(VtorAspect.class);

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
        //endregion
        //获取方法参数的注解
        Annotation[][] annotations = targetMethod.getParameterAnnotations();
        //获取方法参数的值
        Object[] args = joinPoint.getArgs();
        //收集实际需要的验证错误
        List<String> errorMessages = new ArrayList<>();

        if (annotations != null) {
            int i = 0;
            for (Annotation[] tempAnnotation : annotations) {
                Object arg = args[i];
                //遍历第二维数组获取参数注解, 并且获取Valid注解
                for (Annotation annotation : tempAnnotation) {
                    if (annotation.annotationType() == Valid.class) {
                        Valid valid = (Valid) annotation;

                        Vtor            vtor   = new Vtor();
                        List<Violation> result = vtor.validate(arg);
                        if (result != null) {
                            //region 过滤出期望的验证错误信息
                            for (Violation violation : result) {
                                for (String field : valid.value()) {
                                    if (valid.isInclude()) {
                                        if (field.equals(violation.getName())) {
                                            errorMessages.add(violation.getCheck().getMessage());
                                            break;
                                        }
                                    } else {
                                        if (!field.equals(violation.getName())) {
                                            errorMessages.add(violation.getCheck().getMessage());
                                            break;
                                        }
                                    }
                                }
                            }
                            //endregion
                        }
                    }
                }
                i++;
            }
        }

        if (errorMessages.size() > 0) {
            throw new VtorException(errorMessages);
        }
    }
}
