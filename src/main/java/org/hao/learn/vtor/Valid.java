package org.hao.learn.vtor;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Valid {
    //一种是要验证的包含字段, 一种是要验证的排除字段
    //包含字段isInclude=true, 排除isInclude=false
    String[] value() default {};

    boolean isInclude() default true;
}
