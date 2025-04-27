package com.ruogu.agent.demo.invoke;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;

/***
 *@author ruogu
 *@date 2025/4/27 16:34
 **/
public class LangChainAiInvoke  {

    private static final String API_KEY = "sk-4fe1bd815896478bb4bf76170840c678";

    public static void main(String[] args) {
        ChatLanguageModel qwenModel = QwenChatModel.builder()
                .apiKey(API_KEY)
                .modelName("qwen-max")
                .build();
        String answer = qwenModel.chat("你好");
        System.out.println(answer);
    }

}
