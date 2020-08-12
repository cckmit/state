package com.example.demolearnamqp.controller;

import com.example.demolearnamqp.bean.WorkorderBaseDao;
import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.inter.StateMachineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private WorkorderBaseDao workorderBaseDao;
    @Autowired
    private StateMachineService stateMachineService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/test")
    public Object test() {

        WorkOrderStateMachine stateMachine = stateMachineService.initOrLoadStateMachine(3L);
        stateMachine.thereIsAFeeForSubmittingTheProcessingResult();

        return Arrays.asList("xxx","asdasd", "asdasd", "dasdasasdasddddasdddddddddadasdsadddddddddddd");
    }
}
