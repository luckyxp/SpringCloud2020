package com.xp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.security.auth.login.CredentialNotFoundException;

/**
 * @author Climb.Xu
 * @date 2020/4/11 20:57
 */
@RestController
@Slf4j
public class OrderZKController {
    @Resource
    RestTemplate restTemplate;
    public static final String INVOKE_URL = "http://cloud-payment-service";
    @GetMapping("/consumer/payment/zk")
    public String payMentInfo() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
