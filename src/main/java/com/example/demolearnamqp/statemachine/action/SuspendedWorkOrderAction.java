package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.IWorkOrderAction;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;

/**
 * 已挂起
 */
public class SuspendedWorkOrderAction extends WorkOrderActionAdapter {
    private static final SuspendedWorkOrderAction instance = new SuspendedWorkOrderAction();
    private SuspendedWorkOrderAction() {}
    public static SuspendedWorkOrderAction getInstance() {
        return instance;
    }

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.suspended;
    }

    @Override
    public void administratorUnhook(WorkOrderStateMachine stateMachine) {
        IWorkOrderAction previousState = stateMachine.getPreviousState();
        super.administratorUnhook(stateMachine);
        stateMachine.setCurrentState(previousState);
    }
}
