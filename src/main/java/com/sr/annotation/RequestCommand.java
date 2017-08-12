package com.sr.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * @Authot: shaorui
 * @Description: 执行命令的注解
 * @Date: 22:51 2017/8/12
 */
public @interface RequestCommand {
    public RequestCommandType value();
}