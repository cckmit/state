package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import org.springframework.stereotype.Component;

/**
 * 待支付
 */
@Component
public class ToBePaidWorkOrderAction extends WorkOrderActionAdapter {

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.toBePaid;
    }

    @Override
    public void paymentCompleted(WorkOrderStateMachine stateMachine) {
        super.paymentCompleted(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.toBeConfirmedWorkOrderAction);
    }
}
