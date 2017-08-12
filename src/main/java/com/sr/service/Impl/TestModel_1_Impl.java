package com.sr.service.Impl;

import com.sr.service.Inte.TestModel_1;
import org.springframework.stereotype.Service;
/**
 * @Authot: shaorui
 * @Description: 模拟业务模块1
 * @Date: 22:53 2017/8/12
 */
@Service
public class TestModel_1_Impl implements TestModel_1{

    public void TestCommand_1(String parpm) {
        System.out.println("TestModel_1:TestModel_1:" + parpm);
    }

    public void TestCommand_2(String parpm) {
        System.out.println("TestModel_1:TestModel_2:" + parpm);
    }

    public void TestCommand_3(String parpm) {
        System.out.println("TestModel_1:TestModel_3:" + parpm);
    }
}