package com.ruogu.agent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruogu.agent.model.entity.ConversationMemory;

import java.util.List;

/**
 * @author ruogu
 * @description 针对表【conversation_memory(会话记忆存储表)】的数据库操作Service
 * @createDate 2025-05-10 16:30:22
 */
public interface ConversationMemoryService extends IService<ConversationMemory> {

    /**
     * 根据会话id获取会话记录
     *
     * @param conversationId 会话id
     * @return 会话记录
     */
    List<ConversationMemory> getMessages(String conversationId);

    /**
     * 根据会话id删除会话记录
     *
     * @param conversationId 会话id
     */
    boolean deleteMemory(String conversationId);
}
