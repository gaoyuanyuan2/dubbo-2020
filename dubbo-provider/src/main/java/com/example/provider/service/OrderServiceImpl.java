package com.example.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.common.DemoService;
import com.example.common.OrderService;
import com.example.dto.OrderDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Service(version="1.0.0", timeout = 1000, loadbalance = "roundrobin",interfaceClass = OrderService.class)
@Component
public class OrderServiceImpl implements OrderService {
    @HystrixCommand
    @Override
    public List<OrderDto> getOrderList() {
        if (Math.random() > 0.5) {
            throw new RuntimeException();
        }
        OrderDto order1 = new OrderDto("123456", 59.6, "手机壳");
        OrderDto order2 = new OrderDto("456789", 99.1, "台历");
        return Arrays.asList(order1, order2);
    }
}
