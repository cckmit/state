package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 待分配
 */
@Data
@Component
public class ToBeAssignedWorkOrderAction extends WorkOrderActionAdapter implements Serializable {

    private final String name = WorkOrderState.toBeAssigned.name();

    @Override
    public WorkOrderState getType() {
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
        if (WorkOrderStateMachine.hangUpCheck.compareAndSet(stateMachine, Boolean.FALSE, Boolean.TRUE)) {
            stateMachine.setCurrentState(WorkOrderBase.suspendedWorkOrderAction);
        }
    }

    @Override
    public void judgedAsUnprocessable(WorkOrderStateMachine stateMachine) {
        super.judgedAsUnprocessable(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.finishedWorkOrderAction);
    }
}
