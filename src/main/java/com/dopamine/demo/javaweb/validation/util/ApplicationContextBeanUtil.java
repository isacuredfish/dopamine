package com.dopamine.demo.javaweb.validation.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author chenzi.ma
 * @date 2022/12/27 13:45
 * 通过spring容器获取类对象
 **/
@Component
public class ApplicationContextBeanUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContextSpring;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContextSpring = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz){
        return applicationContextSpring.getBean(clazz);
    }
}
