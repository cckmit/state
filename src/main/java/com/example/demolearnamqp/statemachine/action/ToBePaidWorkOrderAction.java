package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;

/**
 * 待支付
 */
public class ToBePaidWorkOrderAction extends WorkOrderActionAdapter {
    private static final ToBePaidWorkOrderAction instance = new ToBePaidWorkOrderAction();
    private ToBePaidWorkOrderAction() {}
    public static ToBePaidWorkOrderAction getInstance() {
        return instance;
    }

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.toBePaid;
    }

    @Override
    public void paymentCompleted(WorkOrderStateMachine stateMachine) {
        super.paymentCompleted(stateMachine);
        stateMachine.setCurrentState(ToBeConfirmedWorkOrderAction.getInstance());
    }
}
