
package com.dopamine.demo.javaweb.validation.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义校验注解
 */
@Constraint(validatedBy = ValidLogicImpl.class)
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface ValidLogic {

    /**
     * 提醒内容
     */
    String message() default "";

    /**
     * 自定义校验实现类，需实现BeanValidator
     */
    Class<? extends BeanValidator> targetClass();

    /**
     * 分组功能
     */
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
