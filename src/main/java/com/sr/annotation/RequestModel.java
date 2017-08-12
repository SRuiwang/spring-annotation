package com.sr.annotation;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * @Authot: shaorui
 * @Description: 请求模块注解
 * @Date: 22:52 2017/8/12
 */
public @interface RequestModel {
    public RequestModelType value();
}