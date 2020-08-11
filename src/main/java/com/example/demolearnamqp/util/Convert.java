package com.example.demolearnamqp.util;

import com.example.demolearnamqp.dto.WorkOrderStateMachineRedis;
import com.example.demolearnamqp.entity.WorkOrder;
import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;

public class Convert {

    public static WorkOrderStateMachineRedis createByMachine(WorkOrderStateMachine machine) {
        WorkOrderStateMachineRedis workOrderStateMachineRedis = new WorkOrderStateMachineRedis();
        workOrderStateMachineRedis.setId(machine.getWorkOrder().getId());
        workOrderStateMachineRedis.setHangUpFlag(machine.getHangUpFlag());
        workOrderStateMachineRedis.setCurrentState(machine.getCurrentState().getType().name());
        workOrderStateMachineRedis.setPreviousState(machine.getPreviousState().getType().name());
        return workOrderStateMachineRedis;
    }

    public static WorkOrderStateMachine createByMachineRedis(WorkOrderStateMachineRedis machineRedis) {
        WorkOrderStateMachine workOrderStateMachine = new WorkOrderStateMachine(new WorkOrder(machineRedis.getId()));
        workOrderStateMachine.setHangUpFlag(machineRedis.isHangUpFlag());
        workOrderStateMachine.setCurrentState(WorkOrderBase.getByType(machineRedis.getCurrentState()));
        workOrderStateMachine.setPreviousState(WorkOrderBase.getByType(machineRedis.getPreviousState()));
        return workOrderStateMachine;
    }

}
