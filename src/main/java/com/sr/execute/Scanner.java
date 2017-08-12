package com.sr.execute;

import com.sr.annotation.RequestCommand;
import com.sr.annotation.RequestModel;
import com.sr.annotation.RequestModelType;
import com.sr.annotation.RequestCommandType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Authot: shaorui
 * @Description: 用于扫描带有自定义注解的服务模块
 * @Date: 21:29 2017/8/12
 */

@Component
public class Scanner implements BeanPostProcessor {
    /**
     * @Authot: shaorui
     * @Description: spring 初始化bean 前执行
     * @Date: 21:31 2017/8/12
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces != null && interfaces.length > 0) {
            for (Class<?> mInterface : interfaces) {
                RequestModel annotation = mInterface.getAnnotation(RequestModel.class);
                if (annotation == null) {
                    continue;
                }
                Method[] methods = mInterface.getMethods();
                if (methods == null || methods.length == 0) {
                    continue;
                }
                for (Method method : methods) {
                    RequestCommand annotation1 = method.getAnnotation(RequestCommand.class);
                    if (annotation1 == null) {
                        continue;
                    }
                    InvokerHolder.addInvoker(annotation.value(), annotation1.value(), Invoke.valueOf(bean, method));
                }
            }
        }
        return bean;
    }

    /**
     * @Authot: shaorui
     * @Description: spring 初始化bean 后执行
     * @Date: 21:33 2017/8/12
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}