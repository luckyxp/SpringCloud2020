package com.xp.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Climb.Xu
 * @date 2020/4/25 15:15
 */
@RestController
@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT) //自动刷新配置 //proxyMode = ScopedProxyMode.DEFAULT用于解决获取到空值
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    private String getConfigInfo() {
        return configInfo;
    }
}
