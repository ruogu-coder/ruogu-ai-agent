package com.ruogu.agent.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ruogu
 * @date 2025/4/27 12:01
 */
@ConfigurationProperties(prefix = "ruogu.ai")
@Data
@Component
public class RuoguAiProperties {

    /**
     * 灵积 dashscope
     */
    private DashScopeProperties dashScopeProperties;

    @Data
    public static class DashScopeProperties {
        /**
         * api key
         */
        private String apiKey;
        /**
         * 是否启用
         */
        private Boolean enable;
        /**
         * 模型
         */
        private String model;
    }

}
