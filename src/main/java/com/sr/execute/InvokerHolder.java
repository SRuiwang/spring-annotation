package com.sr.execute;

import com.sr.annotation.RequestCommandType;
import com.sr.annotation.RequestModelType;

import java.util.HashMap;
import java.util.Map;

/**
 * @Authot: shaorui
 * @Description: 执行器管理器
 * @Date: 21:50 2017/8/12
 */
public class InvokerHolder {

    public static Map<RequestModelType, Map<RequestCommandType, Invoke>> invokers = new HashMap<RequestModelType, Map<RequestCommandType, Invoke>>();


    /**
     * @Authot: shaorui
     * @Description: 增加执行器
     * @Date: 22:01 2017/8/12
     */
    public static void addInvoker(RequestModelType modelType, RequestCommandType commandType, Invoke invoke) {
        Map<RequestCommandType, Invoke> requestCommandInvokeMap = invokers.get(modelType);
        if (requestCommandInvokeMap == null) {
            requestCommandInvokeMap = new HashMap<RequestCommandType, Invoke>();
            requestCommandInvokeMap.put(commandType, invoke);
            invokers.put(modelType,requestCommandInvokeMap);
        } else {
            Invoke invoke1 = requestCommandInvokeMap.get(commandType);
            if (invoke1 == null) {
                requestCommandInvokeMap.put(commandType, invoke);
            } else {
                System.out.println("执行器modle:" + modelType + ",commond:" + commandType + "重复注册");
            }
        }
    }

    /**
     * @Authot: shaorui
     * @Description: 获取执行器
     * @Date: 22:01 2017/8/12
     */
    public static Invoke getInvoker(RequestModelType modelType, RequestCommandType commandType) {
        Map<RequestCommandType, Invoke> requestCommandInvokeMap = invokers.get(modelType);
        if (requestCommandInvokeMap != null) {
            return requestCommandInvokeMap.get(commandType);
        }
        return null;
    }
}