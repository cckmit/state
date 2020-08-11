package com.example.demolearnamqp.aspect;

import com.example.demolearnamqp.bean.StateMachineBaseDao;
import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.util.Convert;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Aspect
@Component
public class WorkOrderActionAspect {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private StateMachineBaseDao stateMachineBaseDao;

    @Pointcut("execution(public * com.example.demolearnamqp.statemachine.action.*.*(com.example.demolearnamqp.statemachine.WorkOrderStateMachine)))")
    public void BrokerAspect() {
    }

    @Around("BrokerAspect()")
    public Object doAroundGame(ProceedingJoinPoint pjp) throws Throwable {
        // 状态机参数
        WorkOrderStateMachine machine = (WorkOrderStateMachine) pjp.getArgs()[0];
        // 反转状态机状态
        machine.resetPreviousState();
        // 多实例并发控制
        String lockKey = "lock:" + machine.getWorkOrder().getId();
        try {
            redisTemplate.execute((RedisCallback<Object>) redisConnection -> {
                while (true) {
                    if (redisConnection.set(lockKey.getBytes(), "".getBytes(),
                            Expiration.from(1, TimeUnit.MINUTES), RedisStringCommands.SetOption.SET_IF_ABSENT)) {
                        // 如果没有，则抢到锁
                        try {
                            log.info(machine.toString());
                            pjp.proceed();
                            log.info(machine.toString());
                            // update machine
                            stateMachineBaseDao.save(Convert.createByMachine(machine));
                        } catch (Throwable throwable) {
                            log.error(throwable.getMessage(), throwable);
                        }
                        break;
                    } else {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                }
                return null;
            });
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            redisTemplate.delete(lockKey);
        }
        return null;
    }
}