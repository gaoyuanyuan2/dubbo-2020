package com.example.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.common.DemoService;
import org.springframework.stereotype.Component;

@Service(version="1.0.0", timeout = 1000, loadbalance = "roundrobin",interfaceClass = DemoService.class)
@Component
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return name + " my test 2020！";
    }
}
