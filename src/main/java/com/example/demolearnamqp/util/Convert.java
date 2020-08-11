package com.example.demolearnamqp.util;

import com.example.demolearnamqp.bean.StateMachineBase;
import com.example.demolearnamqp.bean.WorkOrder;
import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;

public class Convert {

    public static StateMachineBase createByMachine(WorkOrderStateMachine machine) {
        StateMachineBase stateMachineBase = new StateMachineBase();
//        workOrderStateMachineRedis.setId(machine.getWorkOrder().getId());
        stateMachineBase.setHangUpFlag(machine.getHangUpFlag());
        stateMachineBase.setCurrentState(machine.getCurrentState().getType().name());
        stateMachineBase.setPreviousState(machine.getPreviousState().getType().name());
        return stateMachineBase;
    }

    public static WorkOrderStateMachine createByMachineRedis(StateMachineBase machineRedis) {
        WorkOrderStateMachine workOrderStateMachine = new WorkOrderStateMachine(new WorkOrder(machineRedis.getId()));
        workOrderStateMachine.setHangUpFlag(machineRedis.isHangUpFlag());
        workOrderStateMachine.setCurrentState(WorkOrderBase.getByType(machineRedis.getCurrentState()));
        workOrderStateMachine.setPreviousState(WorkOrderBase.getByType(machineRedis.getPreviousState()));
        return workOrderStateMachine;
    }

}
