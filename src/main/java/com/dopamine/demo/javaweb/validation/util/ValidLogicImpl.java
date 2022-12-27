

package com.dopamine.demo.javaweb.validation.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * DTO验证
 *
 * @author 何阳阳
 * @version 1.0 2018年1月16日
 * @see ValidLogicImpl
 * @since 1.0
 */
@Component
public class ValidLogicImpl implements ConstraintValidator<ValidLogic, Object> {

    /**
     * BeanValidator
     */
    private BeanValidator validator;

    @Autowired
    private static ApplicationContext applicationContext;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(ValidLogic constraintAnnotation) {
        validator = ApplicationContextBeanUtil.getBean(constraintAnnotation.targetClass());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        List<String> validResult = validator.valid(value);
        return null == validResult || validResult.isEmpty();
    }

}
