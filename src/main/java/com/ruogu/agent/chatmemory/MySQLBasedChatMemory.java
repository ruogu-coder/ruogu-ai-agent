package com.ruogu.agent.chatmemory;

import cn.hutool.core.collection.CollectionUtil;
import com.google.gson.Gson;
import com.ruogu.agent.model.entity.ConversationMemory;
import com.ruogu.agent.model.enums.MessageTypeEnum;
import com.ruogu.agent.service.ConversationMemoryService;
import lombok.AllArgsConstructor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/***
 *@author ruogu
 *@date 2025/5/10 16:34
 **/
@Component
@AllArgsConstructor
public class MySQLBasedChatMemory implements ChatMemory {

    private final ConversationMemoryService conversationMemoryService;

    @Override
    public void add(String conversationId, List<Message> messages) {
        Gson gson = new Gson();
        List<ConversationMemory> conversationMemories = messages.stream().map(message -> {
            String messageType = message.getMessageType().getValue();
            String mes = gson.toJson(message);
            return ConversationMemory.builder().conversationId(conversationId)
                    .messageType(messageType).messageContent(mes).build();
        }).toList();
        conversationMemoryService.saveBatch(conversationMemories);
    }


    @Override
    public List<Message> get(String conversationId, int lastN) {
        List<ConversationMemory> messages = conversationMemoryService.getMessages(conversationId);
        if (CollectionUtil.isEmpty(messages)) {
            return List.of();
        }
        return messages.stream()
                .skip(Math.max(0, messages.size() - lastN))
                .map(this::getMessage)
                .collect(Collectors.toList());
    }

    @Override
    public void clear(String conversationId) {
        boolean deleted = conversationMemoryService.deleteMemory(conversationId);
        if (!deleted) {
            throw new RuntimeException("Failed to clear conversation memory");
        }
    }

    private Message getMessage(ConversationMemory conversationMemory) {
        String content = conversationMemory.getMessageContent();
        Gson gson = new Gson();
        return (Message) gson.fromJson(content, MessageTypeEnum.fromValue(conversationMemory.getMessageType()).getClazz());
    }
}