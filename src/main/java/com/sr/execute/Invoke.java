package com.sr.execute;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Authot: shaorui
 * @Description: 抽象执行器
 * @Date: 21:50 2017/8/12
 */
public class Invoke {

    /*
     * 目标对象
     */
    private Object targetObject;

    /*
     * 目标方法
     */
    private Method targetMethod;

    public static Invoke valueOf(Object o, Method m){
        Invoke invoke = new Invoke();
        invoke.setTargetObject(o);
        invoke.setTargetMethod(m);
        return invoke;
    }

    /*
     * 执行
     */
    public Object invoke(Object[] args) {
        try {
            this.targetMethod.invoke(this.targetObject, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(Method targetMethod) {
        this.targetMethod = targetMethod;
    }
}