package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 已分配
 */
@Data
@Component
public class AllocatedWorkOrderAction extends WorkOrderActionAdapter implements Serializable {

    private final String name = WorkOrderState.allocated.name();

    @Override
    public WorkOrderState getType() {
        return WorkOrderState.allocated;
    }

    @Override
    public void receiveWorkOrder(WorkOrderStateMachine stateMachine) {
        super.receiveWorkOrder(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.orderReceivedWorkOrderAction);
    }

    @Override
    public void administratorSuspendOperation(WorkOrderStateMachine stateMachine) {
        super.administratorSuspendOperation(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.suspendedWorkOrderAction);
    }
}
