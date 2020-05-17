package com.xp.springcloud.controller;

import com.xp.springcloud.service.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Climb.Xu
 * @date 2020/5/12 10:05
 */
@RestController
public class MessageController {
    @Resource
    private MessageProvider provider;

    @GetMapping("/send/{msg}")
    public Boolean sendMessage(@PathVariable("msg") String msg) {
        return provider.send(msg);
    }
}
