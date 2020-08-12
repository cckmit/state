package com.example.demolearnamqp.util;

import com.example.demolearnamqp.bean.StateMachineBase;
import com.example.demolearnamqp.bean.WorkOrderActionLog;
import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;

import java.time.LocalDateTime;

public class Convert {

    public static StateMachineBase createByMachine(WorkOrderStateMachine machine) {
        StateMachineBase stateMachineBase = new StateMachineBase();
        stateMachineBase.setId(machine.getWorkOrder().getId());
        stateMachineBase.setHangUpFlag(machine.getHangUpFlag());
        stateMachineBase.setCurrentState(machine.getCurrentState().getType().name());
        stateMachineBase.setPreviousState(machine.getPreviousState().getType().name());
        return stateMachineBase;
    }

    public static StateMachineBase createById(Long id) {
        StateMachineBase stateMachineBase = new StateMachineBase();
        stateMachineBase.setId(id);
        stateMachineBase.setHangUpFlag(Boolean.FALSE);
        stateMachineBase.setCurrentState(WorkOrderBase.toBeAssignedWorkOrderAction.getType().name());
        stateMachineBase.setPreviousState(WorkOrderBase.toBeAssignedWorkOrderAction.getType().name());
        return stateMachineBase;
    }

    public static WorkOrderStateMachine createByMachineRedis(StateMachineBase machineRedis) {
        WorkOrderStateMachine workOrderStateMachine = new WorkOrderStateMachine();
        workOrderStateMachine.setHangUpFlag(machineRedis.isHangUpFlag());
        workOrderStateMachine.setCurrentState(WorkOrderBase.getByType(machineRedis.getCurrentState()));
        workOrderStateMachine.setPreviousState(WorkOrderBase.getByType(machineRedis.getPreviousState()));
        return workOrderStateMachine;
    }

    public static WorkOrderActionLog createWorkOrderActionLogByStateMachineBase(StateMachineBase machineRedis) {
        WorkOrderActionLog workOrderActionLog = new WorkOrderActionLog();
        workOrderActionLog.setPreviousState(machineRedis.getPreviousState());
        workOrderActionLog.setCurrentState(machineRedis.getCurrentState());
        workOrderActionLog.setHangUpFlag(machineRedis.isHangUpFlag());
        workOrderActionLog.setWorkOrderId(machineRedis.getId());
        workOrderActionLog.setChangeStateDate(LocalDateTime.now());
        return workOrderActionLog;
    }
}
