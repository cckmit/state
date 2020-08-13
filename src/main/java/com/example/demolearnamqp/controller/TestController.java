package com.example.demolearnamqp.controller;

import com.example.demolearnamqp.rocketmq.Send;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private Send send;

    @GetMapping("/test")
    public Object test() {
        send.sendMessage();
        return Arrays.asList("xxx","asdasd", "asdasd", "dasdasasdasddddasdddddddddadasdsadddddddddddd");
    }
}
