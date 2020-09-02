package com.example.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.common.DemoService;
import com.example.common.LogicService;
import com.example.common.OrderService;
import com.example.dto.OrderDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LogicServiceImpl implements LogicService {

    @Reference(version = "1.0.0", interfaceClass = OrderService.class)
    private OrderService orderService;

    @HystrixCommand(fallbackMethod="fallbackMethod")
    @Override
    public List<OrderDto> getOrderList() {
        return orderService.getOrderList();
    }

    public List<OrderDto> fallbackMethod() {
        return Arrays.asList( new OrderDto("0000000", 0.01, "fallbackMethod"));
    }
}
