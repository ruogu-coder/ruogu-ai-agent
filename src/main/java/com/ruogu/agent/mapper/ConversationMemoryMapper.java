package com.ruogu.agent.mapper;

import com.ruogu.agent.model.entity.ConversationMemory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ruogu
* @description 针对表【conversation_memory(会话记忆存储表)】的数据库操作Mapper
* @createDate 2025-05-10 16:30:22
* @Entity com.ruogu.agent.model.entity.ConversationMemory
*/
@Mapper
public interface ConversationMemoryMapper extends BaseMapper<ConversationMemory> {

}




