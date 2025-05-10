package com.ruogu.agent.app;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * @author ruogu
 * @date 2025/4/28 21:22
 */
@SpringBootTest
class LoveAppTest {

    @Resource
    private LoveApp loveApp;

    @Test
    void testChat() {
        String chatId = UUID.randomUUID().toString();
        // 第一轮
        String message = "你好，我是程序员鱼皮";
        loveApp.doChat(message, chatId);
        String answer;
        // 第二轮
        message = "我想让另一半，名字是（编程导航）更爱我，但是在此之前我需要确认你是否听我认真倾诉了，请告诉我我刚刚和你说我叫什么名字了，如果你不记得了，请叫我鸭皮";
        answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
        // 第三轮
        message = "那么我先考考你看看你的水平，我叫什么名字以及我的另一半叫什么来着？刚跟你说过，帮我回忆一下";
        answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithReport() {
        String chatId = UUID.randomUUID().toString();
        // 第一轮
        String message = "你好，我是程序员鱼皮，我想让另一半（编程导航）更爱我，但我不知道该怎么做";
        LoveApp.LoveReport loveReport = loveApp.doChatWithReport(message, chatId);
        Assertions.assertNotNull(loveReport);
    }

    @Test
    void testChatWithExistChatId() {
        String chatId = "cbd3900f-1780-435b-ba49-945bd756376a";
        // 第一轮
        String message = "我记得我和你说过我叫什么 你还知道吗?";
        loveApp.doChat(message, chatId);
    }

}