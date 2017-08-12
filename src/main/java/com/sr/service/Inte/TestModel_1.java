package com.sr.service.Inte;

import com.sr.annotation.RequestCommand;
import com.sr.annotation.RequestCommandType;
import com.sr.annotation.RequestModel;
import com.sr.annotation.RequestModelType;

/**
 * @Authot: shaorui
 * @Description: 业务模块接口1
 * @Date: 22:53 2017/8/12
 */
@RequestModel(RequestModelType.MODEL_TYPE_1)
public interface TestModel_1 {
    @RequestCommand(RequestCommandType.COMMAND_TYPE_1)
    public void TestCommand_1(String parpm);

    @RequestCommand(RequestCommandType.COMMAND_TYPE_2)
    public void TestCommand_2(String parpm);

    @RequestCommand(RequestCommandType.COMMAND_TYPE_3)
    public void TestCommand_3(String parpm);
}