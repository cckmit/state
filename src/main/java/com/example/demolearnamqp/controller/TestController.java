package com.example.demolearnamqp.controller;

import com.example.demolearnamqp.entity.WorkOrder;
import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
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

    @GetMapping("/test")
    public Object test() {

        WorkOrderStateMachine machine = new WorkOrderStateMachine(new WorkOrder(1L));
        machine.administratorSuspendOperation();

//        redisTemplate.opsForValue().set("test55", Convert.createByMachine(machine));
//        log.info("执行输出操作");
//
//        WorkOrderStateMachineRedis redis = (WorkOrderStateMachineRedis) redisTemplate.opsForValue().get("test55");
//        WorkOrderStateMachine machine1 = Convert.createByMachineRedis(redis);
//        log.info(machine1.toString());

        return Arrays.asList("asdasd", "mmmmmm");
    }

}
