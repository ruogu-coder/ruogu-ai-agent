package com.ruogu.agent.demo.invoke.util;

import cn.hutool.setting.yaml.YamlUtil;
import com.ruogu.agent.config.RuoguAiProperties;

import java.util.Map;

/**
 * @author ruogu
 * @date 2025/4/27 13:05
 */
public class PropertiesReadUtil {

    public static RuoguAiProperties.DashScopeProperties loadConfig() {
        Map<?, ?> configMap = YamlUtil.loadByPath("application-local.yml");
        Map<?, ?> ruoguAi = (Map<?, ?>) configMap.get("ruogu");
        Map<?, ?> ruoguAiMap = (Map<?, ?>) ruoguAi.get("ai");
        Map<?, ?> dashScope = (Map<?, ?>) ruoguAiMap.get("dash-scope");
        RuoguAiProperties.DashScopeProperties dashScopeProperties = new RuoguAiProperties.DashScopeProperties();
        dashScopeProperties.setApiKey((String) dashScope.get("api-key"));
        dashScopeProperties.setEnable(Boolean.getBoolean(dashScope.get("enable").toString()));
        dashScopeProperties.setModel((String) dashScope.get("model"));
        return dashScopeProperties;
    }

}
