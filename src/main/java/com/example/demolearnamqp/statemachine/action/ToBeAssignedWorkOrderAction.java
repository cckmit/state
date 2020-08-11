package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import org.springframework.stereotype.Component;

/**
 * 待分配
 */
@Component
public class ToBeAssignedWorkOrderAction extends WorkOrderActionAdapter {

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.toBeAssigned;
    }

    @Override
    public void workOrderAllocation(WorkOrderStateMachine stateMachine) {
        super.workOrderAllocation(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.allocatedWorkOrderAction);
    }

    @Override
    public void workOrderAllocationDefaultOrder(WorkOrderStateMachine stateMachine) {
        super.workOrderAllocationDefaultOrder(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.orderReceivedWorkOrderAction);
    }

    @Override
    public void administratorSuspendOperation(WorkOrderStateMachine stateMachine) {
        super.administratorSuspendOperation(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.suspendedWorkOrderAction);
    }

    @Override
    public void judgedAsUnprocessable(WorkOrderStateMachine stateMachine) {
        super.judgedAsUnprocessable(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.finishedWorkOrderAction);
    }
}
