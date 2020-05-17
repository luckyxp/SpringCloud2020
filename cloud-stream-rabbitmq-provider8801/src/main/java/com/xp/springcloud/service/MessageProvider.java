package com.xp.springcloud.service;

/**
 * @author Climb.Xu
 * @date 2020/5/12 9:55
 */
public interface MessageProvider {
    Boolean send(String serial);
}
