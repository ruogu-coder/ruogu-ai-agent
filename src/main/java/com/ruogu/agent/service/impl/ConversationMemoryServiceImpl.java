package com.ruogu.agent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruogu.agent.model.entity.ConversationMemory;
import com.ruogu.agent.service.ConversationMemoryService;
import com.ruogu.agent.mapper.ConversationMemoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ruogu
* @description 针对表【conversation_memory(会话记忆存储表)】的数据库操作Service实现
* @createDate 2025-05-10 16:30:22
*/
@Service
public class ConversationMemoryServiceImpl extends ServiceImpl<ConversationMemoryMapper, ConversationMemory>
    implements ConversationMemoryService{

    @Override
    public List<ConversationMemory> getMessages(String conversationId) {
        return this.lambdaQuery()
                .eq(ConversationMemory::getConversationId, conversationId)
                .list();
    }

    @Override
    public boolean  deleteMemory(String conversationId) {
        return this.lambdaUpdate()
                .eq(ConversationMemory::getConversationId, conversationId)
                .remove();
    }
}




