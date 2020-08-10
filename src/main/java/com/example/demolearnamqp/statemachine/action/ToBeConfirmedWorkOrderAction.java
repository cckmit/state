package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;

/**
 * 待确认
 */
public class ToBeConfirmedWorkOrderAction extends WorkOrderActionAdapter {
    private static final ToBeConfirmedWorkOrderAction instance = new ToBeConfirmedWorkOrderAction();
    private ToBeConfirmedWorkOrderAction() {}
    public static ToBeConfirmedWorkOrderAction getInstance() {
        return instance;
    }

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.toBeConfirmed;
    }

    @Override
    public void confirmWorkOrder(WorkOrderStateMachine stateMachine) {
        super.confirmWorkOrder(stateMachine);
        stateMachine.setCurrentState(CommentWorkOrderAction.getInstance());
    }
}
