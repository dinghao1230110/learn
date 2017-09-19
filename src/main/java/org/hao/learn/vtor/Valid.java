package org.hao.learn.vtor;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Valid {
    //要验证的字段
    String[] value() default {};
}
