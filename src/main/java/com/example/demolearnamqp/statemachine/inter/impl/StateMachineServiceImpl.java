package com.example.demolearnamqp.statemachine.inter.impl;

import com.example.demolearnamqp.bean.StateMachineBase;
import com.example.demolearnamqp.bean.StateMachineBaseDao;
import com.example.demolearnamqp.bean.WorkOrder;
import com.example.demolearnamqp.bean.WorkorderBaseDao;
import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.inter.StateMachineService;
import com.example.demolearnamqp.util.Convert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class StateMachineServiceImpl implements StateMachineService {

    @Autowired
    private StateMachineBaseDao stateMachineBaseDao;
    @Autowired
    private WorkorderBaseDao workorderBaseDao;

    @Override
    public WorkOrderStateMachine initOrLoadStateMachine(Long id) {
        WorkOrderStateMachine byMachineRedis;
        // read db
        Optional<StateMachineBase> machineBase = stateMachineBaseDao.findById(id);
        if (machineBase.isPresent()) {
            // 存在
            log.info("加载");
            byMachineRedis = Convert.createByMachineRedis(machineBase.get());
        } else {
            // 不存在
            log.info("初始化");
            StateMachineBase stateMachineBase = Convert.createById(id);
            stateMachineBaseDao.save(stateMachineBase);
            byMachineRedis = Convert.createByMachineRedis(stateMachineBase);
        }
        Optional<WorkOrder> workOrder = workorderBaseDao.findById(id);
        workOrder.ifPresent(byMachineRedis::setWorkOrder);
        return byMachineRedis;
    }
}