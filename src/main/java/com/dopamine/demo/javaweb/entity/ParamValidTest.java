package com.dopamine.demo.javaweb.entity;

import com.dopamine.demo.javaweb.validation.ValidTestConstraint;
import com.dopamine.demo.javaweb.validation.util.ValidLogic;
import lombok.Data;

/**
 * @author chenzi.ma
 * @date 2022/12/27 11:22
 **/
@Data
@ValidLogic(targetClass = ValidTestConstraint.class)
public class ParamValidTest {
    public String name;

    public int age;
}
