package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import org.springframework.stereotype.Component;

/**
 * 已分配
 */
@Component
public class AllocatedWorkOrderAction extends WorkOrderActionAdapter {

    @Override
    public WorkOrderState getName() {
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
