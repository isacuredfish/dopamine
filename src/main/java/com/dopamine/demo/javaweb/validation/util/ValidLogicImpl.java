

package com.dopamine.demo.javaweb.validation.util;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * 自定义校验实现类
 */
@Component
public class ValidLogicImpl implements ConstraintValidator<ValidLogic, Object> {

    /**
     * BeanValidator
     */
    private BeanValidator validator;

    /**
     *
     */
    @Override
    public void initialize(ValidLogic constraintAnnotation) {
        validator = ApplicationContextBeanUtil.getBean(constraintAnnotation.targetClass());
    }

    /**
     *
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        List<String> validResult = validator.valid(value);
        return null == validResult || validResult.isEmpty();
    }

}
