package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;

/**
 * 待分配
 */
public class ToBeAssignedWorkOrderAction extends WorkOrderActionAdapter {
    private static final ToBeAssignedWorkOrderAction instance = new ToBeAssignedWorkOrderAction();
    private ToBeAssignedWorkOrderAction() {}
    public static ToBeAssignedWorkOrderAction getInstance() {
        return instance;
    }

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.toBeAssigned;
    }

    @Override
    public void workOrderAllocation(WorkOrderStateMachine stateMachine) {
        super.workOrderAllocation(stateMachine);
        stateMachine.setCurrentState(AllocatedWorkOrderAction.getInstance());
    }

    @Override
    public void workOrderAllocationDefaultOrder(WorkOrderStateMachine stateMachine) {
        super.workOrderAllocationDefaultOrder(stateMachine);
        stateMachine.setCurrentState(OrderReceivedWorkOrderAction.getInstance());
    }

    @Override
    public void administratorSuspendOperation(WorkOrderStateMachine stateMachine) {
        super.administratorSuspendOperation(stateMachine);
        stateMachine.setCurrentState(SuspendedWorkOrderAction.getInstance());
    }

    @Override
    public void judgedAsUnprocessable(WorkOrderStateMachine stateMachine) {
        super.judgedAsUnprocessable(stateMachine);
        stateMachine.setCurrentState(FinishedWorkOrderAction.getInstance());
    }
}
