package com.dopamine.demo.javaweb.validation;

import com.dopamine.demo.javaweb.validation.util.BeanValidator;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenzi.ma
 * @date 2022/12/27 11:31
 **/
@Component
public class ValidTestConstraint implements BeanValidator {

    @Override
    public List<String> valid(Object value) {
        System.out.println("自定义注解");
        return null;
    }
}
