package com.ruogu.agent.demo.invoke;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;

/***
 *@author ruogu
 *@date 2025/4/27 16:17
 * 取消 @Component 注释，可启动时执行
 * 简单对话场景
 **/
// @Component
public class SpringAiAiInvoke implements CommandLineRunner {

    @Resource
    private ChatModel dashscopeChatModel;

    @Override
    public void run(String... args) throws Exception {
        AssistantMessage output = dashscopeChatModel.call(new Prompt("你好，我是若谷"))
                .getResult()
                .getOutput();
        System.out.println(output.getText());
    }
}
