package com.xp.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Climb.Xu
 * @date 2020/4/14 16:42
 * 自定义轮询算法,实现负载均衡
 */
@Component("loadBalancer")
public class MyLoadBalancer implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement() {
        int expect;
        int update;
        do {
            expect = this.atomicInteger.get();
            update = expect > 2147483647 ? 0 : expect + 1;
        } while (! this.atomicInteger.compareAndSet(expect, update));
        System.out.println("+++++update: " + update);
        return update;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        return serviceInstances.get(getAndIncrement() % serviceInstances.size());
    }
}
