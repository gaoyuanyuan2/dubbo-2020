package com.example.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.common.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Reference(version = "1.0.0", interfaceClass = DemoService.class)
    private DemoService demoService;

    @GetMapping("/hello/{name}")
    public String Hello(@PathVariable("name") String s) {
        String ret_msg = "empty string...";

        if (demoService != null)
            ret_msg = demoService.sayHello(s);
        else {
            System.out.println("Dubbo service is null.");
        }

        return ret_msg;
    }

}
