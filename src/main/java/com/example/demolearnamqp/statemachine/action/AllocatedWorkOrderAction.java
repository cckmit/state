package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;

/**
 * 已分配
 */
public class AllocatedWorkOrderAction extends WorkOrderActionAdapter {
    private static final AllocatedWorkOrderAction instance = new AllocatedWorkOrderAction();
    private AllocatedWorkOrderAction() {}
    public static AllocatedWorkOrderAction getInstance() {
        return instance;
    }

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.allocated;
    }

    @Override
    public void receiveWorkOrder(WorkOrderStateMachine stateMachine) {
        super.receiveWorkOrder(stateMachine);
        stateMachine.setCurrentState(OrderReceivedWorkOrderAction.getInstance());
    }

    @Override
    public void administratorSuspendOperation(WorkOrderStateMachine stateMachine) {
        super.administratorSuspendOperation(stateMachine);
        stateMachine.setCurrentState(SuspendedWorkOrderAction.getInstance());
    }
}
