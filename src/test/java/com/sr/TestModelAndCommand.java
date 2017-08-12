package com.sr;

import com.sr.annotation.RequestCommandType;
import com.sr.annotation.RequestModel;
import com.sr.annotation.RequestModelType;
import com.sr.execute.Invoke;
import com.sr.execute.InvokerHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestModelAndCommand {

    /**
     * @Authot: shaorui
     * @Description: 测试调用模块以及子方法
     * @Date: 22:54 2017/8/12
     */
    @Test
    public void test1(){
        RequestModelType modelType = RequestModelType.MODEL_TYPE_1;

        RequestCommandType commandType = RequestCommandType.COMMAND_TYPE_1;
        Invoke invoker = InvokerHolder.getInvoker(modelType, commandType);
        Object[] objs = new Object[1];
        objs[0] = "第一次调用";
        invoker.invoke(objs);
    }

}