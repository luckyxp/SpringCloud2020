package com.xp.springcloud.service.impl;

import com.xp.springcloud.dao.PaymentDao;
import com.xp.springcloud.pojo.Payment;
import com.xp.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Climb.Xu
 * @date 2020/4/8 1:33
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}
