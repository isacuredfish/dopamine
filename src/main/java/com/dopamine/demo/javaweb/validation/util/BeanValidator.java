
package com.dopamine.demo.javaweb.validation.util;

import java.util.List;

/**
 * 自定义校验接口类
 */
public interface BeanValidator {

    /**
     * 获取Message的i18n表示
     *
     * @param messageCode 消息代码
     * @param args 参数
     * @return message
     */
    default String getMessage(String messageCode, String... args) {
        return "defult";
    }

    /**
     * 验证方法
     *
     * @param value 需要被验证的业务对象
     * @return 验证消息，如果为空则表示验证通过
     * @since 1.0
     */
    List<String> valid(Object value);
}
