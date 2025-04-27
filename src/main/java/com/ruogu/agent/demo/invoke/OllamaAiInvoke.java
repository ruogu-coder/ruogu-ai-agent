package com.ruogu.agent.demo.invoke;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;

/***
 *@author ruogu
 *@date 2025/4/27 17:33
 * 取消注释即可在 SpringBoot 项目启动时执行
 **/
// @Component
public class OllamaAiInvoke implements CommandLineRunner {

    @Resource
    private ChatModel ollamaChatModel;

    @Override
    public void run(String... args) throws Exception {
        AssistantMessage output = ollamaChatModel.call(new Prompt("你好,请问如何创建一个springboot项目"))
                .getResult()
                .getOutput();
        System.out.println(output.getText());
    }
}
