package com.example.demolearnamqp.controller;

import com.example.demolearnamqp.bean.StateMachineBaseDao;
import com.example.demolearnamqp.bean.WorkorderBaseDao;
import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.inter.StateMachineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private StateMachineBaseDao stateMachineBaseDao;
    @Autowired
    private WorkorderBaseDao workorderBaseDao;
    @Autowired
    private StateMachineService stateMachineService;

    @GetMapping("/test")
    public Object test() {

//        WorkOrder workOrder = new WorkOrder();
//        workOrder.setId(2L);
//        workOrder.setTitle("xxx");
//        workOrder.setContent("UUUUUUUUUUUUUUUUU");
//
//        workorderBaseDao.save(workOrder);
//        workorderBaseDao.saveAndFlush(workOrder);

        WorkOrderStateMachine workOrderStateMachine = stateMachineService.initOrLoadStateMachine(1L);
        log.info(workOrderStateMachine.toString());

        return Arrays.asList("asdasd", "mmmmmm");
    }

}
