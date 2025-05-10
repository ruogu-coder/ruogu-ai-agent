-- 创建库
create database if not exists ruogu_ai_agent;

-- 切换库
use ruogu_ai_agent;

DROP TABLE IF EXISTS `conversation_memory`;
CREATE TABLE `conversation_memory`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `conversation_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会话id',
    `message_type`    varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息类型',
    `message_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息内容',
    `create_time`     datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
    `update_time`     datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
    `deleted`         bit(1)                                                       NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX             `idx_conv_prefix`(`conversation_id`(10)) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会话记忆存储表' ROW_FORMAT = Dynamic;

