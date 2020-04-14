package com.xp.springcloud.service;

import com.xp.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Climb.Xu
 * @date 2020/4/8 1:32
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
